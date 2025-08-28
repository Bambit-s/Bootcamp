package com.example.demo.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.Period;

public class PeriodDeserializer extends JsonDeserializer<Period> {

    @Override
    public Period deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        int years = node.get("years").asInt(0);
        int months = node.get("months").asInt(0);
        int days = node.get("days").asInt(0);

        return Period.of(years, months, days);
    }
}
