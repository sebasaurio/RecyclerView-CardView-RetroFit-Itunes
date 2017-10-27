package app.desarrollo.ituneszenteno.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("resultCount")
    private Long resultCount;

    @SerializedName("results")
    private List<Contenido> results = null;
    private final static long serialVersionUID = 122750186429224465L;

    public Long getResultCount() {
        return resultCount;
    }

    public void setResultCount(Long resultCount) {
        this.resultCount = resultCount;
    }

    public List<Contenido> getResults() {
        return results;
    }

    public void setResults(List<Contenido> results) {
        this.results = results;
    }

}
