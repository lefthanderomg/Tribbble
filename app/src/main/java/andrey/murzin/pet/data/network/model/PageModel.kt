package andrey.murzin.pet.data.network.model

import com.google.gson.annotations.SerializedName

data class PageModel<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val result: List<T>
)