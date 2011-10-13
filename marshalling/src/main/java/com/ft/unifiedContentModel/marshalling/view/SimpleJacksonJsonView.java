package com.ft.unifiedContentModel.marshalling.view;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class SimpleJacksonJsonView extends MappingJacksonJsonView {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	      
	private JsonEncoding encoding = JsonEncoding.UTF8;
	      
	private boolean prefixJson = false;

	/**
	 * Overridden return just the value stored for the 'model' attribute key (i.e. the wrapper around 
	 * the model is removed. All attributes other than 'model' are ignored.
	 * 
	 */
	@Override
    @SuppressWarnings("unchecked")
    protected Object filterModel(Map<String, Object> model) {
        Map<String, Object> filteredModel = (Map<String, Object>) super.filterModel(model);
        return filteredModel.get(ModelAndViewNames.MODEL_NAME);
    }
	
	/**
	 * Overridden to add the content length to the response so that it is consistent with the xml response
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Object value = filterModel(model);
				ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
		 		JsonGenerator generator =
						objectMapper.getJsonFactory().createJsonGenerator(bos, encoding);
		 		if (prefixJson) {
		 			generator.writeRaw("{} && ");
		 		}
		 		objectMapper.writeValue(generator, value);
		
				response.setContentLength(bos.size());
				FileCopyUtils.copy(bos.toByteArray(), response.getOutputStream());
	}
	
	@Override
	public void setObjectMapper(ObjectMapper objectMapper) {
		super.setObjectMapper(objectMapper);
		this.objectMapper = objectMapper;
	}
	
	@Override
	public void setEncoding(JsonEncoding encoding) {
		super.setEncoding(encoding);
		this.encoding = encoding;
	}
	
	@Override
	public void setPrefixJson(boolean prefixJson) {
		super.setPrefixJson(prefixJson);
		this.prefixJson = prefixJson;
	}
}
