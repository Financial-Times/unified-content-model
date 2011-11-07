package com.ft.unifiedContentModel.model;

import static org.apache.commons.lang.StringUtils.EMPTY;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="image")
@XmlType(name="image", namespace=XSDs.IMAGE_NAMESPACE, propOrder = {"url", "type","source", "alt", "caption"})
public class TypeBasedImage implements Image {
	
	private String url;
	private ImageType imageType;
	private String source;
	private String alt;
	private String caption;
	
	protected void init (String url, ImageType type,String source, String alt, String caption) {
		this.url = url;
		this.imageType = type;
		this.source = source;
		this.alt = alt;
		this.caption = caption;
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
