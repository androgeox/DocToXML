//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * Created by Georgiy on 28.09.2016.
// */
//public class Writer {
//    public Writer(Word word) {
//        try{
//            FileWriter filewriter = new FileWriter("D:\\Javaprog\\DocToXML\\test.xml");
//            JAXBContext context = JAXBContext.newInstance(Word.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.marshal(word, filewriter);
//        }catch(IOException io){
//            io.printStackTrace();
//        }catch(JAXBException e){
//            e.printStackTrace();
//        }
//    }
//
//
//}
