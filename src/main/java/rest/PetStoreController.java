package rest;

import com.google.gson.Gson;
import hillel.lesson08.Logger;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import rest.entities.Order;

import java.io.IOException;

public class PetStoreController {

    private static String apiURL = "https://petstore3.swagger.io/api/v3";

    public void createNewPetWithJson() throws IOException {
        JSONObject petDataJson = new JSONObject();
        petDataJson.put("id", 11);
        petDataJson.put("name", "doggie2");

        JSONObject categoryJson = new JSONObject();
        categoryJson.put("id", 1);
        categoryJson.put("name", "Dogs");
        petDataJson.put("category", categoryJson);

        String[] photosArray = {"test"};
        petDataJson.put("photoUrls", photosArray);

        JSONObject tagJson = new JSONObject();
        tagJson.put("id", 0);
        tagJson.put("name", "String");
        JSONArray tags = new JSONArray();
        tags.put(tagJson);
        petDataJson.put("tags", tags);

        petDataJson.put("status", "available");

//        RequestBody body = RequestBody.create(petDataJson.toString().getBytes());

        RequestBody body = RequestBody.create(petDataJson.toString(), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(apiURL + "/pet")
                .post(body)
                .header("Content-Type", "application?json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            Logger.warning("Response code NOT 200!");
        } else {
            Logger.info("Request sent, response code is 200");
        }
        System.out.println(response.body().string());

    }

    public void getPetById(int id) throws IOException {
        Request request = new Request.Builder()
                .url(apiURL + "/pet/" + id)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            Logger.warning("Response code NOT 200!");
        } else {
            Logger.info("Request sent, response code is 200");
        }
        System.out.println(response.body().string());
    }

    public void addOrder() throws IOException {
        JSONObject orderDataJson = new JSONObject();
        orderDataJson.put("id", 555);
        orderDataJson.put("petId", 10);
        orderDataJson.put("quantity", 8);
        orderDataJson.put("shipDate", "2023-07-08T11:18:22.209Z");
        orderDataJson.put("status", "approved");
        orderDataJson.put("complete", true);

//        RequestBody body = RequestBody.create(orderDataJson.toString().getBytes());

//        MediaType mediaTypeJSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(mediaTypeJSON, orderDataJson.toString());

        RequestBody body = RequestBody.create(orderDataJson.toString(), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(apiURL + "/store/order")
                .header("Content-Type", "application?json")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            Logger.warning("Response code NOT 200!");
        } else {
            Logger.info("Request sent, response code is 200");
        }
        System.out.println(response.body().string());
    }

    public Order addOrderWithGson(Order order) throws IOException {
        Gson gson = new Gson();

//        RequestBody body = RequestBody.create(gson.toJson(post).getBytes());
        RequestBody body = RequestBody.create(gson.toJson(order), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(apiURL + "/store/order")
                .header("Content-Type", "application?json")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            Logger.warning("Response code NOT 200!");
        } else {
            Logger.info("Request sent, response code is 200");
        }
        String res = response.body().string();
        System.out.println(res);
        Order newOrder = gson.fromJson(res, Order.class);
        return newOrder;
    }

}
