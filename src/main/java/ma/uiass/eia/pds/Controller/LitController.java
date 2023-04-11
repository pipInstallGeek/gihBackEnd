    package ma.uiass.eia.pds.Controller;

    import jakarta.ws.rs.*;
    import jakarta.ws.rs.core.MediaType;
    import ma.uiass.eia.pds.Model.*;
    import ma.uiass.eia.pds.Service.*;
    import java.util.List;
    import java.util.Map;

    @Path("/lit")
    public class LitController {
        LitService service1=new LitService();
        ILitService service = new LitService();
        IEspaceService<Chambre> chambreService = new ChambreService();
        IEspaceService<Salle> salleService = new SalleService();
        IMarqueService marqueService = new MarqueService();
        ITypeLitService typeLitService = new TypeLitService();

        @GET
        @Path("/getlits")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Lit> getLit(){
            return service.afficherTout();
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
        @Path("/getlitById")
        @Produces(MediaType.APPLICATION_JSON)
        public Lit getById(int id){return service.trouverId(id) ;  }
        @GET
        @Path("/getAvailableLit{nomService}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public List<Lit> getAvailableLit(@PathParam("nomService") String nomService) {
            return service.afficherToutL(nomService);
        }
        @GET
        @Path("/getnldb")
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, Integer> getNLDB() {
            return service1.getNLDB();
        }
        @GET
        @Path("/getnlo")
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, Integer> getNLO() {
            return service1.getNLO();
        }


    }
