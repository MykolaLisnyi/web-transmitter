package com.LMI.webtransmitter.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "category",
        "name",
        "photoUrls",
        "tags",
        "status"
})

public class Pet {

    public Pet() {
    }

    public Pet(Integer id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<Tag> tags;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public static class Builder {
        private Integer buildId;
        private Category buildCategory;
        private String buildName;
        private List<String> buildPhotoUrls;
        private List<Tag> buildTags;
        private String buildStatus;

        public Builder() {
            buildId = 1;
            buildCategory = new Category(0, "string");
            buildName = "unknown";
            buildPhotoUrls = List.of("\"string\"");
            buildTags = List.of(new Tag(0, "string"));
            buildStatus = "available";
        }

        public Builder withId(Integer id) {
            buildId = id;
            return this;
        }

        public Builder withName(String name) {
            buildName = name;
            return this;
        }

        public Pet build() {
            return new Pet(buildId, buildCategory, buildName, buildPhotoUrls, buildTags, buildStatus);
        }
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("photoUrls")
    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    @JsonProperty("photoUrls")
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id) && category.equals(pet.category) && name.equals(pet.name) && photoUrls.equals(pet.photoUrls) && tags.equals(pet.tags) && status.equals(pet.status) && additionalProperties.equals(pet.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, photoUrls, tags, status, additionalProperties);
    }

    @Override
    public String toString() {
        return  "{" +
                "\"id\":" + id +
                ",\"category\":" + category +
                ",\"name\":\"" + name + "\"" +
                ",\"photoUrls\":" + photoUrls +
                ",\"tags\":" + tags +
                ",\"status\":\"" + status + "\"" +
                "}";
    }
}
