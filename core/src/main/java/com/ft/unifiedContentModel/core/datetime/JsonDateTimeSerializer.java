package com.ft.unifiedContentModel.core.datetime;

import static org.springframework.util.Assert.notNull;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class JsonDateTimeSerializer extends JsonSerializer<DateTime> {

    private DateTimeFormatter dateTimeFormatter;

    public JsonDateTimeSerializer() {
		this(new ISODateTimeFormatter());
	}

	JsonDateTimeSerializer(DateTimeFormatter dateTimeFormatter) {
		notNull(dateTimeFormatter);
		this.dateTimeFormatter = dateTimeFormatter;
	}

    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        if(value != null){
            String formattedDate = dateTimeFormatter.format(value);
            jgen.writeString(formattedDate);
        }
    }
}


