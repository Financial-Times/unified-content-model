package com.ft.api.ucm.model.v1.aspect;

// bad name, but otherwise clash with the Aspect class (that we will hopefully at some point remove)
public enum AspectEnum {
	TITLE("title"),
	LIFECYCLE("lifecycle"),
	NATURE("nature"),
	MASTER("master"),
	PACKAGING("packaging"),
	PACKAGE("package"),
	BODY("body"),
	PROVENANCE("provenance"),
	SUMMARY("summary"),
	EDITORIAL("editorial"),
	LOCATION("location"),
	METADATA("metadata"),
	IMAGES("images"),
	MEDIAASSETS("mediaAssets"),
	ASSETS("assets"),
	AUDIOVISUAL("audioVisual"),
    USAGE("usage");
	
	private final String name;
	
	private static final AspectEnum[] allValidAspects = AspectEnum.values();
	
	private AspectEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static AspectEnum getByValue(String name) {
		if (name != null) {
			for (AspectEnum aspectType: allValidAspects) {
				if (name.equalsIgnoreCase(aspectType.getName())) {
					return aspectType;
				}
			}
		}
		throw new IllegalArgumentException("Invalid AspectEnum value: " + name);
	}

	public static String getValidValues() {
		StringBuilder result = new StringBuilder();
		for (AspectEnum a: AspectEnum.values()) {
			result.append(a.getName());
			result.append(", ");
		}
		return result.substring(0, result.length() - 2).toString();
	}
}
