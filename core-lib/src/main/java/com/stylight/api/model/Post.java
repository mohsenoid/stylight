package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Post implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("teaserImage")
    @Expose
    private String teaserImage;
    @SerializedName("teaserImageHorizontal")
    @Expose
    private Object teaserImageHorizontal;
    @SerializedName("teaserImageDarkBackground")
    @Expose
    private boolean teaserImageDarkBackground;
    @SerializedName("datemodified")
    @Expose
    private String dateModified;
    @SerializedName("datecreated")
    @Expose
    private String dateCreated;
    @SerializedName("category")
    @Expose
    private PostCategory postCategory;
    @SerializedName("sponsor")
    @Expose
    private Object sponsor;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("flexibleContent")
    @Expose
    private List<Object> flexibleContent = new ArrayList<>();
    @SerializedName("tags")
    @Expose
    private List<Object> tags = new ArrayList<>();
    @SerializedName("hasVideo")
    @Expose
    private boolean hasVideo;
    @SerializedName("hasProducts")
    @Expose
    private boolean hasProducts;
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<>();
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<>();
    @SerializedName("items")
    @Expose
    private List<Object> items = new ArrayList<>();
    @SerializedName("itemsHeadline")
    @Expose
    private String itemsHeadline;

    /**
     * No args constructor for use in serialization
     */
    public Post() {
    }

    /**
     * @param tags
     * @param body
     * @param hasProducts
     * @param itemsHeadline
     * @param link
     * @param teaserImageHorizontal
     * @param dateCreated
     * @param type
     * @param sponsor
     * @param teaserImageDarkBackground
     * @param id
     * @param author
     * @param title
     * @param postCategory
     * @param hasVideo
     * @param items
     * @param teaserImage
     * @param images
     * @param slug
     * @param dateModified
     * @param flexibleContent
     * @param products
     */
    public Post(int id, String title, String link, String slug, String teaserImage, Object teaserImageHorizontal, boolean teaserImageDarkBackground, String dateModified, String dateCreated, PostCategory postCategory, Object sponsor, Author author, List<Object> flexibleContent, List<Object> tags, boolean hasVideo, boolean hasProducts, List<Product> products, String type, String body, List<Image> images, List<Object> items, String itemsHeadline) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.slug = slug;
        this.teaserImage = teaserImage;
        this.teaserImageHorizontal = teaserImageHorizontal;
        this.teaserImageDarkBackground = teaserImageDarkBackground;
        this.dateModified = dateModified;
        this.dateCreated = dateCreated;
        this.postCategory = postCategory;
        this.sponsor = sponsor;
        this.author = author;
        this.flexibleContent = flexibleContent;
        this.tags = tags;
        this.hasVideo = hasVideo;
        this.hasProducts = hasProducts;
        this.products = products;
        this.type = type;
        this.body = body;
        this.images = images;
        this.items = items;
        this.itemsHeadline = itemsHeadline;
    }

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * @return The teaserImage
     */
    public String getTeaserImage() {
        return teaserImage;
    }

    /**
     * @param teaserImage The teaserImage
     */
    public void setTeaserImage(String teaserImage) {
        this.teaserImage = teaserImage;
    }

    /**
     * @return The teaserImageHorizontal
     */
    public Object getTeaserImageHorizontal() {
        return teaserImageHorizontal;
    }

    /**
     * @param teaserImageHorizontal The teaserImageHorizontal
     */
    public void setTeaserImageHorizontal(Object teaserImageHorizontal) {
        this.teaserImageHorizontal = teaserImageHorizontal;
    }

    /**
     * @return The teaserImageDarkBackground
     */
    public boolean isTeaserImageDarkBackground() {
        return teaserImageDarkBackground;
    }

    /**
     * @param teaserImageDarkBackground The teaserImageDarkBackground
     */
    public void setTeaserImageDarkBackground(boolean teaserImageDarkBackground) {
        this.teaserImageDarkBackground = teaserImageDarkBackground;
    }

    /**
     * @return The dateModified
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * @param dateModified The dateModified
     */
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * @return The dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated The dateCreated
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return The postCategory
     */
    public PostCategory getPostCategory() {
        return postCategory;
    }

    /**
     * @param postCategory The postCategory
     */
    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    /**
     * @return The sponsor
     */
    public Object getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor The sponsor
     */
    public void setSponsor(Object sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return The flexibleContent
     */
    public List<Object> getFlexibleContent() {
        return flexibleContent;
    }

    /**
     * @param flexibleContent The flexibleContent
     */
    public void setFlexibleContent(List<Object> flexibleContent) {
        this.flexibleContent = flexibleContent;
    }

    /**
     * @return The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     * @param tags The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     * @return The hasVideo
     */
    public boolean isHasVideo() {
        return hasVideo;
    }

    /**
     * @param hasVideo The hasVideo
     */
    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    /**
     * @return The hasProducts
     */
    public boolean isHasProducts() {
        return hasProducts;
    }

    /**
     * @param hasProducts The hasProducts
     */
    public void setHasProducts(boolean hasProducts) {
        this.hasProducts = hasProducts;
    }

    /**
     * @return The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * @return The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

    /**
     * @return The itemsHeadline
     */
    public String getItemsHeadline() {
        return itemsHeadline;
    }

    /**
     * @param itemsHeadline The itemsHeadline
     */
    public void setItemsHeadline(String itemsHeadline) {
        this.itemsHeadline = itemsHeadline;
    }

}
