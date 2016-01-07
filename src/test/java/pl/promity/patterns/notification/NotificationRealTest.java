package pl.promity.patterns.notification;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NotificationRealTest {

    private static final Gson GSON = new Gson();

    /**
     * {
     *    "_id": "5689f76446d288d2f8abcd2e",
     *    "orderDate": "2015-01-26 12:48:12",
     *    "deliverDate": "2015-02-24 07:34:56"
     * }
     */
    private final String validJSON = "{\n" +
            "  \"_id\": \"5689f76446d288d2f8abcd2e\",\n" +
            "  \"orderDate\": \"2015-01-26 12:48:12\",\n" +
            "  \"deliverDate\": \"2015-02-24 07:34:56\"\n" +
            "}";

    /**
     * {
     *    "_id": "5689f76446d288d2f8abcd2e",
     *    "orderDate": "lubie placky",
     *    "deliverDate": "{}"
     * }
     */
    private final String invalidJSON = "{\n" +
            "  \"_id\": \"5689f76446d288d2f8abcd2e\",\n" +
            "  \"orderDate\": \"lubie placky\",\n" +
            "  \"deliverDate\": {}\n" +
            "}";

    public Notification validateJSON(JsonObject jsonObject){
        Notification notification = new Notification(", ");
        validateDate("orderDate", jsonObject, notification);
        validateDate("deliverDate", jsonObject, notification);
        return notification;
    }

    private void validateDate(String dateElementId, JsonObject parentElement, Notification notification){
        JsonElement dateElement = parentElement.get( dateElementId );
        if(dateElement == null ){
            notification.addError(dateElementId + " element doesn't exist");
        }
        else if(!dateElement.isJsonPrimitive()){
            notification.addError(dateElementId + " element is not JSON primitive");
        }
        else {
            String asString = dateElement.getAsString();
            if(!asString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                notification.addError(dateElementId + " element does not match date pattern");
            }
        }
    }


    @Test
    public void testValidJson() throws Exception{
        //given
        JsonObject jsonObject = GSON.fromJson(validJSON, JsonObject.class);

        //when
        Notification notification = validateJSON(jsonObject);

        //then
        System.out.println( "Error messages : " + System.getProperty("line.separator") + notification.errorMessage() );
        assertThat(notification.hasErrors()).isFalse();
    }

    @Test
    public void testInvalidJson() throws Exception{
        //given
        JsonObject jsonObject = GSON.fromJson(invalidJSON, JsonObject.class);

        //when
        Notification notification = validateJSON(jsonObject);

        //then
        System.out.println( "Error messages : " + System.getProperty("line.separator") + notification.errorMessage() );
        assertThat(notification.hasErrors()).isTrue();
    }


}
