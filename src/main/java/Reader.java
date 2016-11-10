import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy on 28.09.2016.
 */
public class Reader {
//    public static final String FILE_NAME = "D:\\Javaprog\\DocToXML\\src\\main\\resources\\adjective_word.txt";
    public static final String FILE_NAME = "D:\\WordTrainer\\app\\src\\main\\res\\xml\\academic.txt";
    Word word;
    BufferedReader buf = null;
//    String[] arrayWord;
//    String[] eng = null;
//    String[] rus = null;
    List<String> arrayWord;
    List<String> eng = new ArrayList<String>();
    List<String> rus = new ArrayList<String>();
    ArrayList<Word> aw;

    public Reader() throws JAXBException {

    try {
        buf = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), Charset.forName("Cp1251")));
//        InputStreamReader is = new InputStreamReader(new FileInputStream(FILE_NAME), Charset.forName("Cp1251"));

//        System.out.println(buf.readLine());
        while (buf!=null ){
            String str = buf.readLine();
            System.out.println(str);
            String[] splitStr = str.split(" - ");
            arrayWord = new ArrayList<String>();
            for (String s : splitStr) {
                arrayWord.add(s);
            }

            for (int i = 0; i <arrayWord.size(); i+=2) {
//                        System.out.println(arrayWord.get(i));
                for (int j = 1; j <arrayWord.size(); j+=2) {
//                            System.out.println(arrayWord.get(j));
                    word = new Word(arrayWord.get(i), arrayWord.get(j));
                    aw = new ArrayList<Word>();
                    aw.add(word);
//                        System.out.println(word);
                }
            }

            for(Word w:aw){
//                    System.out.println(aw);
//                File file = new File("D:\\Javaprog\\DocToXML\\test.xml");
                File file = new File("D:\\WordTrainer\\app\\src\\main\\res\\xml\\academic.xml");
                FileWriter fr = new FileWriter(file,true);
//                    FileWriter filewriter = new FileWriter("D:\\Javaprog\\DocToXML\\test.xml");
                JAXBContext context = JAXBContext.newInstance(Word.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(w, fr);
                }

            }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException io) {
        io.printStackTrace();
    }catch (NullPointerException nul){
        nul.printStackTrace();
        try {
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        finally {
            try {
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
}
