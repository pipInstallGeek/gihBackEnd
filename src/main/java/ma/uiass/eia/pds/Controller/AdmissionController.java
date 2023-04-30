        package ma.uiass.eia.pds.Controller;

        import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
        import ma.uiass.eia.pds.Model.Admission;
        import ma.uiass.eia.pds.Service.AdmissionService;
        import ma.uiass.eia.pds.Service.IAdmissionService;

        import java.util.List;
        @Path("/admission")

        public class AdmissionController {
            IAdmissionService admissionService = new AdmissionService();
            AdmissionService ad =new AdmissionService();
            @GET
            @Path("/getadmissions")
            @Produces(MediaType.APPLICATION_JSON)
            public List<Admission> getAdmission(){
                return admissionService.afficherTout();
            }
          @PUT
          @Path("addadmission/{numAdmission}/{dateE}/{codeLit}")
          @Produces(MediaType.APPLICATION_JSON)
          @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
          public void addAdmission(@PathParam("numAdmission") String numAdmission,
                                   @PathParam("dateE") String dateE,
                                   @PathParam("codeLit") String codeLit) {

              admissionService.addAdmission(numAdmission,dateE,codeLit);}
            @GET
            @Path("/getidMax")
            @Produces(MediaType.APPLICATION_JSON)
            public int getMaxAdmissionIdFromDatabase(){return ad.afficgerIdMax();}
            @PUT
            @Path("updateadmission/{numAdmission}/{dateS}")
            @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
            public void updateAdmission(@PathParam("numAdmission") String numAdmission,
                                        @PathParam("dateS") String dateS) {
                admissionService.updateAdmission( numAdmission,dateS);
            }




        }
