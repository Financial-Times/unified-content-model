package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"title", "headline", "intro", "link", "image"})
public class PromoBoxFields {

    private String title;
    private String headline;
    private String intro;
    private String link;
    private TypeBasedImage image;
    
    public PromoBoxFields() {}
    
    public PromoBoxFields(String title, String headline, String intro, String link, TypeBasedImage image) {
        this.title = title;
        this.headline = headline;
        this.intro = intro;
        this.link = link;
        this.image = image;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TypeBasedImage getImage() {
        return image;
    }

    public void setImage(TypeBasedImage image) {
        this.image = image;
    }
}
