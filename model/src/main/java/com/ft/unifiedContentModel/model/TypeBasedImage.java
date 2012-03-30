package com.ft.unifiedContentModel.model;

import static org.apache.commons.lang.StringUtils.EMPTY;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="image")
@XmlType(name="image", namespace= XSDs.IMAGE_NAMESPACE, propOrder = {"url", "type","source", "alt", "caption", "height", "width"})
public class TypeBasedImage implements com.ft.unifiedContentModel.model.Image {
	
	private String url;
	private ImageType imageType;
	private String source;
	private String alt;
	private String caption;
    private Integer height;
    private Integer width;

    public TypeBasedImage (String url, ImageType type,String source, String alt, String caption) {
		this.url = url;
		this.imageType = type;
		this.source = source;
		this.alt = alt;
		this.caption = caption;
	}

    public TypeBasedImage(String url, ImageType imageType, String source, String alt, String caption, Integer height, Integer width) {
        this.url = url;
        this.imageType = imageType;
        this.source = source;
        this.alt = alt;
        this.caption = caption;
        this.height = height;
        this.width = width;
    }

    protected TypeBasedImage(){
		// required for JAXB
	}
	
	@Override
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	@XmlElement(name="type")
	public String getType() {
		return imageType.toString();
	}

	public void setType(String imageType) {
		this.imageType = ImageType.fromString(imageType);
	}

	@Override
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@Override
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}


    @Override
    public Integer getHeight(){
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public Integer getWidth(){
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		if(o == this){
			return true;
		}
		if(o instanceof TypeBasedImage) {
			TypeBasedImage a = (TypeBasedImage)o;
			return Objects.equal(this.url, a.url);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.url);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
					.add("url", url)
					.add("imageType", imageType)
					.add("source", source)
					.add("alt", alt)
					.add("caption", caption)
					.add("height", height)
					.add("width", width)
					.toString();
	}
	
	@XmlType(namespace=XSDs.IMAGE_NAMESPACE)
	public static enum ImageType {

		PRIMARY("primary"),SECONDARY("secondary"),ALTERNATIVE("alternative"),ARTICLE("article"),POPUP("pop-up"),POPUP_PREVIEW("pop-up-promo"),INLINE("inline"),INLINE_EXT("inline-external"),NULL(null),NONE(EMPTY);

		private String displayName;
		
		private static final Map<String, ImageType> ENUM_NAMES = Maps.newHashMap();
		
		static { 
			for (ImageType imageType : values()) {
				ENUM_NAMES.put(imageType.toString(), imageType);
			}
		}

		public static ImageType fromString(String displayName) {
			return ENUM_NAMES.get(displayName);
		}
		

		private ImageType(String displayName){
			this.displayName = displayName;
		}

		@Override
		public String toString() {
			return displayName;
		}
	}
}
