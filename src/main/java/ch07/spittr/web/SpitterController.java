package ch07.spittr.web;

import ch07.spittr.Spitter;
import ch07.spittr.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

/*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart(value = "profilePicture", required = false) Part fileBytes,
            RedirectAttributes redirectAttributes,
            @Valid Spitter spitter,
            Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        spitterRepository.save(spitter);
        redirectAttributes.addAttribute("username", spitter.getUsername());
        redirectAttributes.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}";
    }
*/

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm,
            Errors errors) throws IllegalStateException, IOException {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        profilePicture.transferTo(new File("/tmp/spittr/" + spitter.getUsername() + ".jpg"));
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(
                    spitterRepository.findByUsername(username));
        }
        return "profile";
    }

/*
    private void saveImage(MultipartFile image) throws ImageUploadException {
        try {
            AWSCredentials awsCredentials = new AWSCredentials(s3AccessKey, s3SecretKey);
            S3Service s3 = new RestS3Service(awsCredentials);

            S3Bucket bucket = s3.getBucket("spittrImages");
            S3Object imageObject = new S3Object(image.getOriginalFilename());

            imageObject.setDataInputStream(image.getInputStream());
            imageObject.setContentLength(image.getSize());
            imageObject.setContentType(image.getContentType());

            AccessControlList acl = new AccessControlList();
            acl.setOwner(bucket.getOwner());
            acl.grantPermission(GroupGrants.ALL_USERS, Permission.PERMISSION_READ);
            imageObject.setAcl(acl);

            s3.putObject(bucket, imageObject);
        } catch (Exception e) {
            throw new ImageUploadException("Unable to save image", e);
        }
    }
*/

}
