package ge.sangu.paata.manual;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created for intermediate exam
 */
public class TextProcessing {

    public static void main(String[] args) {
        try {
            URI uri = TextProcessing.class.getResource("./data/data.txt").toURI();
            List<String> striqonebi = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

            List<String> strofebi = new ArrayList<String>();

            int strofi = 1;
            for (int i = 0; i < striqonebi.size(); i++) {
                if (striqonebi.get(i).trim().equals(String.valueOf(strofi))) {
                    if (i + 4 < striqonebi.size() && striqonebi.get(i + 1).length() > 30
                            && striqonebi.get(i + 2).length() > 30
                            && striqonebi.get(i + 3).length() > 30
                            && striqonebi.get(i + 4).length() > 30) {
                        //strofebi.add(String.valueOf(strofi));
                        strofebi.add(striqonebi.get(i + 1));
                        strofebi.add(striqonebi.get(i + 2));
                        strofebi.add(striqonebi.get(i + 3));
                        strofebi.add(striqonebi.get(i + 4));
                        i += 4;
                        strofi++;
                    }
                }
            }

            List<String> terminebi = new ArrayList<String>();
            List<String> keyWordsFull = new ArrayList<String>(Arrays.asList("amxanagi", "sikeTe", "sibrZne", "goneba", "mamaci", "siqvele", "siyvaruli", "siuxve", "sircxvili", "sinatife", "sixaruli", "sicrue", "ugulo", "jabani", "saxelovani", "mSvenieri", "mSveniereba", "saTno", "SiSi", "braZi", "risxva", "mrisxaneba", "boroteba", "boroti", "janmrTeloba", "jani", "simSvide", "mSvidi", "uxvi", "siZunwe", "Suri", "brwyinvale", "mdabali", "maRali", "gangebiani", "mowyale", "samarTliani", "gonieri", "goniereba", "cudi", "siarbe", "siuxve", "bedniereba", "siamovneba"));
            List<String> keyWords = new ArrayList<String>(Arrays.asList("amxanag", "sikeT", "sibrZn", "goneb", "mamac", "siqvel", "siyvarul", "siuxv", "sircxvil", "sinatif", "sixarul", "sicru", "ugulo", "jaban", "saxelovan", "mSvenier", "mSveniereb", "saTno", "SiS", "braZ", "risxv", "mrisxaneb", "boroteb", "boroti", "janmrTelob", "jani", "simSvid", "mSvid", "uxv", "siZunw", "Suri", "brwyinvale", "mdabal", "maRal", "gangebian", "mowyale", "samarTlian", "gonier", "goniereb", "cudi", "sixarb", "siuxv", "bedniereb", "siamovneb"));


            for (int j = 0; j < keyWords.size(); j++) {
                String key = keyWords.get(j);
                terminebi.add("");
                terminebi.add(keyWordsFull.get(j));
                terminebi.add("");
                for (int i = 0; i < striqonebi.size(); i++) {
                    if (striqonebi.get(i).contains(key)) {
                        terminebi.add(striqonebi.get(i) + " - " + i / 4 + ", " + (i % 4 + 1));
                    }
                }
            }

            for (String item : terminebi) {
                System.out.println(item);
            }

        } catch (Exception ex) {
            System.out.println("Error occured");
        }
    }
}

