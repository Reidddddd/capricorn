package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. Encode and Decode TinyURL
 * <p></p>
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 * <p></p>
 */
public class Codec {

  private String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private char[] codec = codes.toCharArray();
  private Map<String, String> codecMapping = new HashMap<>();
  private Random random = new Random();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String key = "";
    while (true) {
      for (int i = 0; i < 5; i++) {
        key = key + codec[random.nextInt(codec.length)];
      }

      if (codecMapping.containsKey(key)) {
        key = "";
        continue;
      }

      codecMapping.put(key, longUrl);
      return key;
    }
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return codecMapping.get(shortUrl);
  }

}
