package Modelo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class SettingsManager {

    private static final String FILENAME = "settings.xml";

    /**
     * Busca la preferencia de tema.
     * @param ci La cédula del usuario.
     * @return "dark" si la preferencia está guardada, "default" en cualquier otro caso.
     */
    public static String getThemePreference(String ci) {
        File xmlFile = new File(FILENAME);
        if (!xmlFile.exists() || ci == null || ci.isEmpty()) {
            return "default";
        }

        try {
            Document doc = getDocument();
            Node userNode = findUserNode(doc, ci);

            if (userNode != null) {
                NodeList childNodes = userNode.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    if ("theme".equals(childNodes.item(i).getNodeName())) {
                        return childNodes.item(i).getTextContent(); // Debería ser "dark"
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "default";
    }

    /**
     * ✅ LÓGICA DE INTERRUPTOR: AGREGAR/BORRAR
     * Si el usuario tiene "dark", se lo quita.
     * Si no lo tiene, se lo agrega.
     * @param ci La cédula del usuario.
     */
    public static void toggleThemePreference(String ci) {
        if (ci == null || ci.isEmpty()) return;
        
        try {
            Document doc = getDocument();
            Element root = doc.getDocumentElement();
            Node userNode = findUserNode(doc, ci);

            // 1. Si el usuario no existe, lo creamos
            if (userNode == null) {
                userNode = doc.createElement("user");
                ((Element) userNode).setAttribute("ci", ci);
                root.appendChild(userNode);
            }

            // 2. Buscamos si ya tiene un nodo <theme>
            Node themeNode = null;
            NodeList childNodes = userNode.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if ("theme".equals(childNodes.item(i).getNodeName())) {
                    themeNode = childNodes.item(i);
                    break;
                }
            }

            // 3. Aplicamos la lógica de interruptor
            if (themeNode != null) {
                // SÍ TIENE EL TEMA: Lo borramos para volver al default
                userNode.removeChild(themeNode);
            } else {
                // NO TIENE EL TEMA: Lo agregamos
                Element newThemeNode = doc.createElement("theme");
                newThemeNode.setTextContent("dark");
                userNode.appendChild(newThemeNode);
            }

            // 4. Guardamos el XML
            saveDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- Métodos Auxiliares de XML ---

    private static Node findUserNode(Document doc, String ci) {
        NodeList userNodes = doc.getElementsByTagName("user");
        for (int i = 0; i < userNodes.getLength(); i++) {
            Node node = userNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                if (el.getAttribute("ci").equals(ci)) {
                    return node;
                }
            }
        }
        return null;
    }

    private static Document getDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File xmlFile = new File(FILENAME);
        if (xmlFile.exists()) {
            return builder.parse(xmlFile);
        } else {
            Document doc = builder.newDocument();
            Element root = doc.createElement("settings");
            doc.appendChild(root);
            return doc;
        }
    }

    private static void saveDocument(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILENAME));
        transformer.transform(source, result);
    }
}