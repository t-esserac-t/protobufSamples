import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws Exception {
    byte[] bytes = Files.readAllBytes(Paths.get("../chat.bin"));
    ChatOuterClass.Chat c = ChatOuterClass.Chat.parseFrom(bytes);

    System.out.printf("from %d to %d: %s (spoiler=%s)%n",
      c.getSendingPlayerID(),
      c.getReceivingPlayerID(),
      c.getChatContent(),
      c.getSpoiler());
  }
}