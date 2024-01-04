package br.com.magicAPI.projectListMagic.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTransformation {
    public static void main(String[] args) throws Exception {
        // Your initial JSON response
        String jsonResponse = "[{\"id\":{\"id_list_card\":6,\"id_card\":1},\"qtdCard\":10}, " +
                "{\"id\":{\"id_list_card\":6,\"id_card\":2},\"qtdCard\":10}, " +
                "{\"id\":{\"id_list_card\":6,\"id_card\":3},\"qtdCard\":10}, " +
                "{\"id\":{\"id_list_card\":6,\"id_card\":4},\"qtdCard\":10}, " +
                "{\"id\":{\"id_list_card\":6,\"id_card\":5},\"qtdCard\":10}]";

        // Transform the JSON
        List<Map<String, Object>> result = transformJson(jsonResponse);

        // Print the result
        System.out.println(result);
    }

    private static List<Map<String, Object>> transformJson(String jsonResponse) throws Exception {
        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON array
        JsonNode jsonNode = mapper.readTree(jsonResponse);

        // Result list
        List<Map<String, Object>> resultList = new ArrayList<>();

        // Process each element in the array
        for (JsonNode node : jsonNode) {
            // Extract values
            JsonNode idNode = node.get("id");
            int idCard = idNode.get("id_card").asInt();
            int qtdCard = node.get("qtdCard").asInt();

            // Create a map for each entry
            Map<String, Object> entryMap = new HashMap<>();
            entryMap.put("Name", "Nome" + idCard); // Replace "Nome" with an appropriate naming convention
            entryMap.put("Qtd", qtdCard);

            // Add the map to the result list
            resultList.add(entryMap);
        }

        // Organize the result list based on your desired format
        Map<String, Object> finalResult = new HashMap<>();
        finalResult.put("Color", "Mono");
        finalResult.put("Name", "Mono-Green");
        finalResult.put("Cards", resultList);

        // Return the final result
        List<Map<String, Object>> finalList = new ArrayList<>();
        finalList.add(finalResult);
        return finalList;
    }
}
