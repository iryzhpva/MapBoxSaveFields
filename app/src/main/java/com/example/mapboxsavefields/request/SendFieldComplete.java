package com.example.mapboxsavefields.request;

import com.example.mapboxsavefields.pojo.Field;

import java.util.List;

public interface SendFieldComplete {
    void successfulSendFields(boolean isSuccessul, String answerSever, List<Field> fields);
}
