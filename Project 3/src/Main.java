
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class SimpleChatbot {

     // A map to store user intents and corresponding responses
     private static final Map<String, String> responses = new HashMap<>();

     static {
         // Initialize predefined responses
         responses.put("hi", "Hello! How can I assist you today?");
         responses.put("hello", "Hi there! How can I help you?");
         responses.put("how are you", "I'm a bot, so I don't have feelings, but I'm here to help you!");
         responses.put("bye", "Goodbye! Have a great day!");
     }

     public class Main {
         public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);
             System.out.println("Chatbot: Hi! Type 'bye' to exit.");

             while (true) {
                 System.out.print("You: ");
                 String userInput = scanner.nextLine().toLowerCase().trim();

                 // Basic input processing and response generation
                 String response = getResponse(userInput);
                 System.out.println("Chatbot: " + response);

                 if ("bye".equalsIgnoreCase(userInput)) {
                     break;
                 }
             }
             scanner.close();
         }

         private static String getResponse(String input) {
             // Tokenize the input
             String[] tokens = tokenize(input);
             for (String token : tokens) {
                 // Check if the token matches any known intent
                 if (responses.containsKey(token)) {
                     return responses.get(token);
                 }
             }
             return "Sorry, I didn't understand that.";
         }

         private static String[] tokenize(String text) {
             // Simple tokenization by splitting on whitespace
             return text.split("\\s+");
         }
     }
 }
