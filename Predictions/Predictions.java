package ma.uiass.eia.pds.Predictions;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Path("/predictions")
public class Predictions {

    @Path("/stateofbeds/{bedstates}/{steps}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response stateofbeds(
            @PathParam("bedstates") String bedstates,
            @PathParam("steps") String steps
    ){

        ProcessBuilder processBuilder = new ProcessBuilder("py", "Python\\PredictionBed.py",bedstates,steps);
        try {
            System.out.print("Being Called");
            System.out.println(bedstates+" "+steps);
            processBuilder.start();
            Process process = processBuilder.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while (((line= input.readLine()))!= null ){
                System.out.println(line);}
            while (((line= error.readLine()))!= null ){
                System.out.println(line);}

            File file = new File("predictionStateOfBeds.png");
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageData = baos.toByteArray();
            return Response.ok()
                    .entity(new StreamingOutput() {
                        @Override
                        public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                            outputStream.write(imageData);
                            outputStream.flush();
                        }
                    }).build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }
}
