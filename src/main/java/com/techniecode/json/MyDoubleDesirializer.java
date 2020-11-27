package com.techniecode.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MyDoubleDesirializer extends JsonDeserializer<Double> {

	@Override
	public Double deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectCodec oc = jp.getCodec();
		TreeNode node = oc.readTree(jp);
		String nodeValue = oc.treeToValue(node, String.class);
		if (nodeValue != null && nodeValue.trim().length() > 0) {
			nodeValue = nodeValue.replace("$", "").replace(",", "");
			return Double.parseDouble(nodeValue);
		}
		return null;
	}

}
