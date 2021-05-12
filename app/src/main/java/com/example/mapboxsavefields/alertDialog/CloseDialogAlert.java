package com.example.mapboxsavefields.alertDialog;

import com.mapbox.geojson.Point;

import java.util.List;

public interface CloseDialogAlert {
    void closeDialogAlertAddCulture(boolean ans, String answer, List<Point> points);
}
