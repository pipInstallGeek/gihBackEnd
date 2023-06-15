package ma.uiass.eia.pds.Controller;

    import jakarta.ws.rs.*;
    import jakarta.ws.rs.core.MediaType;
    import ma.uiass.eia.pds.Model.*;
    import ma.uiass.eia.pds.Service.*;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;

@Path("/lit")
public class LitController {

    ILitService service = new LitService();
    IEspaceService<Chambre> chambreService = new ChambreService();
    IEspaceService<Salle> salleService = new SalleService();
    ITypeLitService typeLitService = new TypeLitService();
    IMarqueService marqueService = new MarqueService();


    @GET
    @Path("/getlits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherTout();
    }

    @GET
    @Path("getlits/{idEspace}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLitByEspace(
            @PathParam("idEspace") int idEspace
    ){
        return service.getLitByEsapce(idEspace);
    }

    @POST
    @Path("/addlit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLit(Lit lit){
        System.out.println(lit);
        service.ajouter(lit);
    }

    @POST
    @Path("/addlit2/{occupe}/{codeespace}/{typelit}/{marque}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLit2(
                        @PathParam("occupe") String occupe,
                        @PathParam("codeespace") String codeespace,
                        @PathParam("typelit") String typelit,
                        @PathParam("marque") String marque){

        Espace espace = salleService.trouverId(Integer.parseInt(codeespace));
        if (espace== null){
         espace = chambreService.trouverId(Integer.parseInt(codeespace));
        }
        TypeLit typeLit = typeLitService.trouverId(Integer.parseInt(typelit));
        Marque marque1 = marqueService.trouverId(Integer.parseInt(marque));

        Lit lit = new Lit( EtatLit.BONNNEETAT, Boolean.parseBoolean(occupe),espace,typeLit,marque1);
            service.ajouter(lit);
    }


        @GET
        @Path("/count/{occupation}")
        @Produces(MediaType.APPLICATION_JSON)
        public Long countOccupation(
                @PathParam("occupation") String occupation){
            return  service.countOccupation(Boolean.parseBoolean(occupation));
        }
        @GET
        @Path("/count/{idEspace}/{occupation}")
        public Long countOccupationInEspace(
                @PathParam("idEspace") int idEspace,
                @PathParam("occupation") String occupation
        ){

        return service.countOccupationInEspace(idEspace, Boolean.parseBoolean(occupation));
    }

        @DELETE
        @Path("/delete/{idLit}")
        public void deleteLit(@PathParam("idLit") int idLit){
            service.deleteLit(idLit);
        }
        @PUT
        @Path("/modify/{lit}/{occupe}/{espacecode}/{etatlit}")
        public void updateLit(
                @PathParam("lit") int lit,
                @PathParam("occupe") String occupe,
                @PathParam("espacecode") int espacecode,
                @PathParam("etatlit") String etatlit

        ){
            service.update(lit, Boolean.parseBoolean(occupe), espacecode, EtatLit.valueOf(etatlit));
        }
        @GET
        @Path("/getlitById/{idLit}")
        @Produces(MediaType.APPLICATION_JSON)
        public Lit getById(@PathParam(("idLit")) int idLit){return service.trouverId(idLit) ;  }
        @GET
        @Path("/getlitByCode/{idLit}")
        @Produces(MediaType.APPLICATION_JSON)
        public Lit findbycode(@PathParam(("idLit")) String idLit){return service.findbycode(idLit) ;  }
        @GET
        @Path("/getAvailableLit{nomService}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public List<Lit> getAvailableLit(@PathParam("nomService") String nomService) {
            return service.afficherToutL(nomService);
        }
        @GET
        @Path("/getEspaceeByService/{nomService}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public List<Espace> getgetEspaceByService(@PathParam("nomService") String nomService) {
            return service.afficherToutE(nomService);
        }
        @GET
        @Path("/getnldb")
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, Integer> getNLDB() {
            return service.getNLDB();
        }
        @GET
        @Path("/getnlo")
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, Integer> getNLO() {
            return service.getNLO();
        }

        @GET
        @Path("/lits/service/{idservice}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Lit> getallbyservice(@PathParam("idservice") int idservice){
            List<Lit> filtred = new ArrayList<>();
            getLit().forEach(lit -> { if (lit.getEspace().getService().getIdService() == idservice){filtred.add(lit);}
            });
            return filtred;
        }
    @GET
    @Path("/GetNBRLitDispoByService/{nomservice}")
    @Produces(MediaType.APPLICATION_JSON)
    public int GetNBRLitDispoByService(@PathParam("nomservice") String nomservice){
        return service.getNBRLitDispoByService(nomservice);
    }
    @GET
    @Path("/GetNBRLitOccupByService/{nomservice}")
    @Produces(MediaType.APPLICATION_JSON)
    public int GetNBRLitOccupByService(@PathParam("nomservice") String nomservice){
        return service.getNBRLitOccupByService(nomservice);
    }


}
