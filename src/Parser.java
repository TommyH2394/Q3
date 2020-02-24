import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parser")
public class Parser {

    @GET
    @Produces("text/plain")
    public String getWebServiceInfo() {
        return "Validator For particular <InputDocument>\n" +
                "\n Payload: XML specified in Developer Technical Questions Q3\n" +
                "\n Execute POST request at URL: http://localhost:8080/Rest_glassfish_hello_world_war_exploded/parser/validateXml with specified payload";
    }

    @POST
    @Path("/validateXml")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response validateXML(String inputDocument) {

        final String EXPECTED_INPUT_DOC = "<InputDocument>\r\n" +
                "\t<DeclarationList>\r\n" +
                "\t\t<Declaration Command=\"DEFAULT\" Version=\"5.13\">\r\n" +
                "\t\t\t<DeclarationHeader>\r\n" +
                "\t\t\t\t<Jurisdiction>IE</Jurisdiction>\r\n" +
                "\t\t\t\t<CWProcedure>IMPORT</CWProcedure>\r\n" +
                "\t\t\t\t\t\t\t<DeclarationDestination>CUSTOMSWAREIE</DeclarationDestination>\r\n" +
                "\t\t\t\t<DocumentRef>71Q0019681</DocumentRef>\r\n" +
                "\t\t\t\t<SiteID>DUB</SiteID>\r\n" +
                "\t\t\t\t<AccountCode>G0779837</AccountCode>\r\n" +
                "\t\t\t</DeclarationHeader>\r\n" +
                "\t\t</Declaration>\r\n" +
                "\t</DeclarationList>\r\n" +
                "</InputDocument>";

        if (inputDocument.trim().equals(EXPECTED_INPUT_DOC)) {
            return Response.status(Response.Status.ACCEPTED).entity("The document was structured correctly").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Error: The document was structured correctly").build();
    }
}