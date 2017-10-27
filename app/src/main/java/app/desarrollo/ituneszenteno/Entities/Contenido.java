package app.desarrollo.ituneszenteno.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Contenido
{

    @SerializedName("data")
    private List<Contenido> list;

    @SerializedName("wrapperType")
    private String wrapperType;
    @SerializedName("kind")
    private String kind;
    @SerializedName("artistId")
    private Long artistId;
    @SerializedName("collectionId")
    private Long collectionId;
    @SerializedName("trackId")
    private Long trackId;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("collectionName")
    private String collectionName;
    @SerializedName("trackName")
    private String trackName;
    @SerializedName("collectionCensoredName")
    private String collectionCensoredName;
    @SerializedName("trackCensoredName")
    private String trackCensoredName;
    @SerializedName("artistViewUrl")
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    private String collectionViewUrl;
    @SerializedName("trackViewUrl")
    private String trackViewUrl;
    @SerializedName("previewUrl")
    private String previewUrl;
    @SerializedName("artworkUrl30")
    private String artworkUrl30;
    @SerializedName("artworkUrl60")
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    private Float collectionPrice;
    @SerializedName("trackPrice")
    private Float trackPrice;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("collectionExplicitness")
    private String collectionExplicitness;
    @SerializedName("trackExplicitness")
    private String trackExplicitness;
    @SerializedName("discCount")
    private Long discCount;
    @SerializedName("discNumber")
    private Long discNumber;
    @SerializedName("trackCount")
    private Long trackCount;
    @SerializedName("trackNumber")
    private Long trackNumber;
    @SerializedName("trackTimeMillis")
    private Long trackTimeMillis;
    @SerializedName("country")
    private String country;
    @SerializedName("currency")
    private String currency;
    @SerializedName("primaryGenreName")
    private String primaryGenreName;
    @SerializedName("isStreamable")
    private Boolean isStreamable;

    private final static long serialVersionUID = -7875870359928577165L;

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public Float getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(Float collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public Float getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Float trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public Long getDiscCount() {
        return discCount;
    }

    public void setDiscCount(Long discCount) {
        this.discCount = discCount;
    }

    public Long getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Long discNumber) {
        this.discNumber = discNumber;
    }

    public Long getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Long trackCount) {
        this.trackCount = trackCount;
    }

    public Long getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Long trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(Long trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public Boolean getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    public List<Contenido> getList() {
        return list;
    }

    public void setList(List<Contenido> list) {
        this.list = list;
    }
}