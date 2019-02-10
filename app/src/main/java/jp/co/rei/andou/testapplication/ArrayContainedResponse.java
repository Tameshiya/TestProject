package jp.co.rei.andou.testapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import jp.co.rei.andou.testapplication.models.CustomType;
import jp.co.rei.andou.testapplication.models.SomeEnum;

class ArrayContainedResponse {

    @SerializedName("array")
    Integer[] array;

    @SerializedName("custom_type_array")
    CustomType[] customTypeArray;

    @SerializedName("custom_type_list")
    List<CustomType> customTypeList;

    @SerializedName("custom_type_set")
    List<CustomType> customTypeSet;

    @SerializedName("some_enum_value")
    SomeEnum someEnumValue;

}
