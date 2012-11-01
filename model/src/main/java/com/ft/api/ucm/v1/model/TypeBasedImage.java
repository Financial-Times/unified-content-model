package com.ft.api.ucm.v1.model;

import static org.apache.commons.lang.StringUtils.EMPTY;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="image")
@JsonPropertyOrder({"url", "type","source", "alt", "caption", "height", "width", "mediaType"})
public class TypeBasedImage implements com.ft.api.ucm.v1.model.Image {
	
	private String url;
	private ImageType imageType;
	private String source;
	private String alt;
	private String caption;
    private Integer height;
    private Integer width;
    private String mediaType;

    public TypeBasedImage (String url, ImageType type,String source, String alt, String caption) {
		this.url = url;
		this.imageType = type;
		this.source = source;
		this.alt = alt;
		this.caption = caption;
	}

    public TypeBasedImage(String url, ImageType imageType, String source, String alt, String caption, Integer height, Integer width, String mediaType) {
        this.url = url;
        this.imageType = imageType;
        this.source = source;
        this.alt = alt;
        this.caption = caption;
        this.height = height;
        this.width = width;
        this.mediaType = mediaType;
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
	public String getType() {
		if (imageType == null) {
			return null;
		}
		return imageType.toString();
	}

	public void setType(String imageType) {
		if (imageType == null) {
			this.imageType = null;
		} else {
			this.imageType = ImageType.fromString(imageType);
		}	
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
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
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
					.add("imageType", imageType.toString())
					.add("source", source)
					.add("alt", alt)
					.add("caption", caption)
					.add("height", height)
					.add("width", width)
					.add("mediaType", mediaType)
					.toString();
	}

	public static enum ImageType {

		PRIMARY("primary"),SECONDARY("secondary"),ALTERNATIVE("alternative"),ARTICLE("article"),POPUP("pop-up"),POPUP_PREVIEW("pop-up-promo"),INLINE("inline"),INLINE_EXT("inline-external"),NULL(null),NONE(EMPTY), WIDE_FORMAT("wide-format"),PROMO("promo");

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
