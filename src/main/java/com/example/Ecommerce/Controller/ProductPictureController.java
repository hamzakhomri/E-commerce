package com.example.Ecommerce.Controller;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Services.ProductPicture.IProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("productpicture")
public class ProductPictureController {
    @Autowired
    IProductPictureService iProductPictureService;
    @PostMapping()
    public Productpicture create(@RequestParam("file") MultipartFile file) throws Exception{
        if (!file.isEmpty()) {
            try {
                byte[] fileContent = file.getBytes();
                Productpicture productpicture = new Productpicture();

                System.out.println("Picture upload successful.");
                System.out.println("file.getOriginalFilename() : "+file.getOriginalFilename());
                System.out.println("file.getName() :"+file.getName());
                System.out.println("file.getContentType() :" +file.getContentType());
                System.out.println("file.getsize() :"+file.getSize());


                //=====THIS FOR COPY PICTURE ON BACK UP
                //String Path_Directory ="../PicturesProducts";
                //Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
                //System.out.println("CopySucces");

                return iProductPictureService.create(fileContent);
            } catch (Exception e) {
                System.out.println("Failed to upload the picture.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No picture selected for upload.");
        }
        return null;
    }


    @GetMapping()
    public List<Productpicture> getAll(){
        return iProductPictureService.GetAll();
    }
    @PutMapping("/{idProductpicture}")
    public Productpicture update(@PathVariable Long idProductpicture,@RequestBody Productpicture productpicture){
        Productpicture updateproductpicture=iProductPictureService.Update(idProductpicture,productpicture);
        if (updateproductpicture!=null){
            return ResponseEntity.ok(updateproductpicture).getBody();
        }else {
            return null;
        }
    }
    @DeleteMapping("/{idProductpicture}")
    public String deleteProductPicutre(@PathVariable Long idProductpicture){
        iProductPictureService.deleteProductPicture(idProductpicture);
        return idProductpicture+": Deleted";
    }

}
