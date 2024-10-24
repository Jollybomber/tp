package seedu.address.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.AbstractBeanField;

/**
 * Custom converter for converting between a CSV string representation of tags
 * and a Set of Strings for the PersonBean class.
 * This class extends AbstractBeanField from OpenCSV to handle conversion
 * of tag data.
 */
public class JsonAdaptedTagConverter extends AbstractBeanField<List<JsonAdaptedTag>, String> {
    @Override
    protected List<JsonAdaptedTag> convert(String value) {
        if (value == null || value.trim().isEmpty()) {
            return new ArrayList<>();
        }
        List<String> stringList = Arrays.asList(value.split(";"));
        return stringList.stream().map(string -> new JsonAdaptedTag(string)).toList();
    }
}