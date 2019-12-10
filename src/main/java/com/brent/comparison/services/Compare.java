package com.brent.comparison.services;

import com.brent.comparison.models.ChangeWrapper;
import com.brent.comparison.models.FlatChange;
import com.brent.comparison.models.NestedParsedObject;

import java.util.List;

public class Compare {

    public static ChangeWrapper diff(Object oldObj, Object newObj) throws Exception {
        return ObjectComparisonService.diff(oldObj, newObj);
    }

    public static List<FlatChange> flatten(Object oldObj, Object newObj) throws Exception {
        ChangeWrapper changeWrapper = ObjectComparisonService.diff(oldObj, newObj);
        if (changeWrapper != null) {
            return FlattenService.flatten(changeWrapper);
        } else return null;
    }

    public static NestedParsedObject buildObject(Object obj) throws Exception {
        return ComparableObjectCreationService.buildOutObject(obj);
    }
}
