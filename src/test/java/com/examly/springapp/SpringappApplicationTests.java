package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

//DAY 3 
@Autowired
    private MockMvc mockMvc;


@Test
@Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
	@Order(2)

    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
	@Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
	@Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }  


	//Day 4 Testcases


    @Test
    @Order(5)
    void Day4_test_UserModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/User.java").isFile());
    }
    
    @Test
    @Order(6)
    void Day4_test_DepartmentModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Department.java").isFile());
    }
    
    @Test
    @Order(7)
    void Day4_test_GrievanceModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Grievance.java").isFile());
    }
    
    @Test
    @Order(8)
    void Day4_test_GrievanceCategory_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/GrievanceCategory.java").isFile());
    }
    
    @Test
    @Order(9)
    void Day4_test_Comment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Comment.java").isFile());
    }
    
    @Test
    @Order(10)
    void Day4_test_Grievance_Has_Entity_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.Grievance");
            Class<?> annotation = Class.forName("jakarta.persistence.Entity");
    
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Entity annotation is missing on Grievance class");
    
        } catch (ClassNotFoundException e) {
            fail("❌ Grievance class not found.");
        } catch (Exception e) {
            fail("❌ Unable to check @Entity annotation on Grievance.");
        }
    }
    

    @Test
@Order(11)
void Day4_test_Grievance_Has_Id_Annotation_On_Field() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.Grievance");
        Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");

        boolean found = false;

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No field in Grievance class is annotated with @Id");

    } catch (ClassNotFoundException e) {
        fail("❌ Grievance class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Id annotation in Grievance class.");
    }
}
   

    //Day 5

    @Test
@Order(12)
void Day5_test_UserRepository_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/repository/UserRepository.java").isFile());
}

@Test
@Order(13)
void Day5_test_DepartmentRepository_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/repository/DepartmentRepository.java").isFile());
}

@Test
@Order(14)
void Day5_test_GrievanceRepository_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/repository/GrievanceRepository.java").isFile());
}

@Test
@Order(15)
void Day5_test_GrievanceCategoryRepository_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/repository/GrievanceCategoryRepository.java").isFile());
}

@Test
@Order(16)
void Day5_test_CommentRepository_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/repository/CommentRepository.java").isFile());
}

@Test
@Order(17)
void Day5_test_UserRepository_Has_Repository_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.repository.UserRepository");
        Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @Repository annotation is missing on UserRepository class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ UserRepository class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Repository annotation on UserRepository.");
    }
}

@Test
@Order(18)
void Day5_test_DepartmentRepository_Has_Repository_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.repository.DepartmentRepository");
        Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @Repository annotation is missing on DepartmentRepository class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ DepartmentRepository class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Repository annotation on DepartmentRepository.");
    }
}

@Test
@Order(19)
void Day5_test_GrievanceRepository_Has_Repository_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.repository.GrievanceRepository");
        Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @Repository annotation is missing on GrievanceRepository class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceRepository class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Repository annotation on GrievanceRepository.");
    }
}

@Test
@Order(20)
void Day5_test_GrievanceCategoryRepository_Has_Repository_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.repository.GrievanceCategoryRepository");
        Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @Repository annotation is missing on GrievanceCategoryRepository class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceCategoryRepository class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Repository annotation on GrievanceCategoryRepository.");
    }
}

@Test
@Order(21)
void Day5_test_CommentRepository_Has_Repository_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.repository.CommentRepository");
        Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @Repository annotation is missing on CommentRepository class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ CommentRepository class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Repository annotation on CommentRepository.");
    }
}

//Day 5
@Test
@Order(22)
void Day6_test_UserController_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/controller/UserController.java").isFile());
}

@Test
@Order(23)
void Day6_test_DepartmentController_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/controller/DepartmentController.java").isFile());
}

@Test
@Order(24)
void Day6_test_GrievanceController_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/controller/GrievanceController.java").isFile());
}

@Test
@Order(25)
void Day6_test_GrievanceCategoryController_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/controller/GrievanceCategoryController.java").isFile());
}

@Test
@Order(26)
void Day6_test_CommentController_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/controller/CommentController.java").isFile());
}

@Test
@Order(27)
void Day6_test_UserController_Has_RestController_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
        Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @RestController annotation is missing on UserController class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ UserController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RestController annotation on UserController.");
    }
}

@Test
@Order(28)
void Day6_test_GrievanceController_Has_RestController_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @RestController annotation is missing on GrievanceController class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RestController annotation on GrievanceController.");
    }
}

@Test
@Order(29)
void Day6_test_GrievanceController_Has_PostMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");

        boolean found = false;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No method with @PostMapping found in GrievanceController");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PostMapping annotation in GrievanceController.");
    }
}

@Test
@Order(30)
void Day6_test_GrievanceController_Has_GetMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");

        boolean found = false;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @GetMapping method found in GrievanceController");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @GetMapping in GrievanceController.");
    }
}

@Test
@Order(31)
void Day6_test_GrievanceController_Has_PutMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");

        boolean found = false;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @PutMapping method found in GrievanceController");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PutMapping in GrievanceController.");
    }
}

@Test
@Order(32)
void Day6_test_GrievanceController_Has_DeleteMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> deleteMapping = Class.forName("org.springframework.web.bind.annotation.DeleteMapping");

        boolean found = false;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) deleteMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @DeleteMapping method found in GrievanceController");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @DeleteMapping in GrievanceController.");
    }
}

@Test
@Order(33)
public void Day6_testCreateGrievance_NoBody_StatusBadRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/grievances")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}

@Test
@Order(34)
public void Day6_testGetAllGrievances_StatusNoContent() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/grievances"))
            .andExpect(MockMvcResultMatchers.status().isNoContent());
}

@Test
@Order(35)
public void Day6_testGetGrievanceById_StatusNotFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/grievances/999"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content()
                    .string(org.hamcrest.Matchers.containsString("Grievance not found")));
}


//Day 7

@Test
@Order(36)
void Day7_test_UserController_Has_RequestMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
        Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

        boolean found = false;

        // Check class-level annotation
        if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
            found = true;
        }

        // Check method-level annotation
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @RequestMapping found on UserController (class or methods)");

    } catch (ClassNotFoundException e) {
        fail("❌ UserController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RequestMapping in UserController.");
    }
}

@Test
@Order(37)
void Day7_test_UserController_Has_PathVariable() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
        Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

        boolean found = false;

        for (Method method : clazz.getDeclaredMethods()) {
            for (Parameter param : method.getParameters()) {
                if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of UserController");

    } catch (ClassNotFoundException e) {
        fail("❌ UserController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PathVariable in UserController.");
    }
}

@Test
@Order(38)
void Day7_test_GrievanceController_Has_RequestMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

        boolean found = false;

        // Check class-level annotation
        if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
            found = true;
        }

        // Check method-level annotation
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @RequestMapping found on GrievanceController (class or methods)");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RequestMapping in GrievanceController.");
    }
}

@Test
@Order(39)
void Day7_test_DepartmentController_Has_RequestMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.DepartmentController");
        Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

        boolean found = false;

        // Check class-level annotation
        if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
            found = true;
        }

        // Check method-level annotation
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @RequestMapping found on DepartmentController (class or methods)");

    } catch (ClassNotFoundException e) {
        fail("❌ DepartmentController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RequestMapping in DepartmentController.");
    }
}

@Test
@Order(40)
void Day7_test_GrievanceController_Has_PathVariable() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceController");
        Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

        boolean found = false;

        for (Method method : clazz.getDeclaredMethods()) {
            for (Parameter param : method.getParameters()) {
                if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        assertTrue(found, "❌ No @PathVariable found in any method parameter of GrievanceController");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PathVariable in GrievanceController.");
    }
}

@Test
@Order(41)
void Day7_test_DepartmentController_Has_PathVariable() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.DepartmentController");
        Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

        boolean found = false;

        for (Method method : clazz.getDeclaredMethods()) {
            for (Parameter param : method.getParameters()) {
                if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        assertTrue(found, "❌ No @PathVariable found in any method parameter of DepartmentController");

    } catch (ClassNotFoundException e) {
        fail("❌ DepartmentController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PathVariable in DepartmentController.");
    }
}


@Test
@Order(42)
void Day7_test_GrievanceCategoryController_Has_RequestMapping() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.GrievanceCategoryController");
        Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

        boolean found = false;

        // Check class-level annotation
        if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
            found = true;
        }

        // Check method-level annotation
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No @RequestMapping found on GrievanceCategoryController (class or methods)");

    } catch (ClassNotFoundException e) {
        fail("❌ GrievanceCategoryController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RequestMapping in GrievanceCategoryController.");
    }
}


//Day 8



@Test
@Order(43)
void Day8_test_UserService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserService.java").isFile());
}

@Test
@Order(44)
void Day8_test_DepartmentService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/DepartmentService.java").isFile());
}

@Test
@Order(45)
void Day8_test_GrievanceService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/GrievanceService.java").isFile());
}

@Test
@Order(46)
void Day8_test_GrievanceCategoryService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/GrievanceCategoryService.java").isFile());
}

@Test
@Order(47)
void Day8_test_CommentService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/CommentService.java").isFile());
}

@Test
@Order(48)
void Day8_test_UserServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserServiceImpl.java").isFile());
}

@Test
@Order(49)
void Day8_test_DepartmentServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/DepartmentServiceImpl.java").isFile());
}

@Test
@Order(50)
void Day8_test_GrievanceServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/GrievanceServiceImpl.java").isFile());
}

@Test
@Order(51)
void Day8_test_GrievanceCategoryServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/GrievanceCategoryServiceImpl.java").isFile());
}

@Test
@Order(52)
void Day8_test_CommentServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/CommentServiceImpl.java").isFile());
}
// POST /api/departments
@Test
@Order(53)
public void Day8_testAddDepartment() throws Exception {
    String requestBody = "{ " +
        "\"departmentName\": \"Water Department\", " +
        "\"contactEmail\": \"water@example.com\", " +
        "\"contactPhone\": \"9876543210\" " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Water Department"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactEmail").value("water@example.com"))
            .andReturn();
}

// GET /api/departments
@Test
@Order(54)
public void Day8_testGetAllDepartments() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].departmentName").value("Water Department"))
            .andReturn();
}

// GET /api/departments/{id}
@Test
@Order(55)
public void Day8_testGetDepartmentById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Water Department"))
            .andReturn();
}

// PUT /api/departments/{id}
@Test
@Order(56)
public void Day8_testUpdateDepartment() throws Exception {
    String requestBody = "{" +
        "\"departmentName\": \"Water & Sanitation Department\", " +
        "\"contactEmail\": \"updated.water@example.com\", " +
        "\"contactPhone\": \"9999999999\"" +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/departments/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Water & Sanitation Department"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.contactEmail").value("updated.water@example.com"))
            .andReturn();
}



@Test
@Order(57)
public void Day9_testPagination_PageNumberApplied() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // ✔ Check only pageNumber
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
}

@Test
@Order(58)
public void Day9_testPagination_PageSizeApplied() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/1/10")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // ✔ Check only pageSize
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
}

@Test
@Order(59)
public void Day9_testPagination_SortingPresent() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // ✔ Check sorting object exists
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort").exists())

            // ✔ sorting.sorted should be boolean (true if sorted)
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort.sorted").isBoolean());
}

@Test
@Order(60)
public void Day9_testPagination_ContentArrayExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // content should be an array, even if empty
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
}

@Test
@Order(61)
public void Day9_testPagination_TotalElementsExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // totalElements should exist
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
}

@Test
@Order(62)
public void Day9_testPagination_TotalPagesExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // totalPages should exist
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
}


@Test
@Order(63)
public void Day10_testAddUser() throws Exception {
    String requestBody = "{ " +
        "\"username\": \"test_user\", " +
        "\"email\": \"test@example.com\", " +
        "\"password\": \"password123\", " +
        "\"role\": \"CITIZEN\", " +
        "\"phoneNumber\": \"1234567890\", " +
        "\"department\": { \"departmentId\": 1 } " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("test_user"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("CITIZEN"))
            .andReturn();
}


@Test
@Order(64)
public void Day10_testGetAllUsers() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("test_user")) 
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("test@example.com"))
            .andReturn();
}

@Test
@Order(65)
public void Day10_testGetUserById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1") // Changed from 2 to 1
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("test_user"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("CITIZEN"))
            .andReturn();
}

// PUT /api/users/{id}
@Test
@Order(66)
public void Day10_testUpdateUser() throws Exception {
    String requestBody = "{ " +
        "\"username\": \"updated_test_user\", " +
        "\"email\": \"updated_test@example.com\", " +
        "\"role\": \"OFFICER\", " +
        "\"phoneNumber\": \"9999999999\" " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/users/1") // Changed from 2 to 1
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("updated_test_user"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("updated_test@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("OFFICER"))
            .andReturn();
}




@Test
@Order(67)
public void Day10_testAddGrievanceCategory() throws Exception {
    // First, let's make sure department with ID 1 exists
    // You might need to create a department first if it doesn't exist
    String deptBody = "{ " +
        "\"departmentName\": \"Water Department\", " +
        "\"contactEmail\": \"water@example.com\", " +
        "\"contactPhone\": \"9876543210\" " +
    "}";
    
    // Create department if needed (assuming ID 1 doesn't exist yet)
    mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(deptBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    String requestBody = "{ " +
        "\"categoryName\": \"Water Supply Issues\", " +
        "\"description\": \"Problems with water supply and quality\", " +
        "\"department\": { \"departmentId\": 1 } " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/grievance-categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Water Supply Issues"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Problems with water supply and quality"))
            .andReturn();
}

@Test
@Order(68)
public void Day10_testGetAllGrievanceCategories() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/grievance-categories")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryName").value("Water Supply Issues")) 
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Problems with water supply and quality"))
            .andReturn();
}

@Test
@Order(69)
public void Day10_testGetGrievanceCategoryById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/grievance-categories/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Water Supply Issues"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Problems with water supply and quality"))
            .andReturn();
}

@Test
@Order(70)
public void Day10_testUpdateGrievanceCategory() throws Exception {
    String requestBody = "{ " +
        "\"categoryName\": \"Updated Water Issues\", " +
        "\"description\": \"Updated description for water related problems\" " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/grievance-categories/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Updated Water Issues"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Updated description for water related problems"))
            .andReturn();
}

@Test
@Order(71)
public void Day11_testSearchGrievanceCategories() throws Exception {
    // First, create a test category with a specific keyword
    String requestBody = "{ " +
        "\"categoryName\": \"Electricity Power Outage\", " +
        "\"description\": \"Issues related to electricity power cuts\", " +
        "\"department\": { \"departmentId\": 1 } " +
    "}";
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/grievance-categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    // Test search for "Electricity" keyword
    mockMvc.perform(MockMvcRequestBuilders.get("/api/grievance-categories/search/Electricity")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryName").value("Electricity Power Outage"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Issues related to electricity power cuts"))
            .andReturn();
}

@Test
@Order(72)
public void Day12_testAddComment() throws Exception {
    // First, ensure we have a grievance and user
    // Create a grievance if needed
    String grievanceBody = "{ " +
        "\"title\": \"Comment Test Grievance\", " +
        "\"description\": \"Grievance for testing comments\", " +
        "\"priority\": \"LOW\", " +
        "\"complainant\": { \"userId\": 1 }, " +
        "\"grievanceCategory\": { \"categoryId\": 1 } " +
    "}";
    
    MvcResult grievanceResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/grievances")
            .contentType(MediaType.APPLICATION_JSON)
            .content(grievanceBody))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    // The grievance created has ID 1 (from your output), not 3
    String requestBody = "{ " +
        "\"content\": \"We have noted your complaint and will look into it\", " +
        "\"isInternal\": false, " +
        "\"grievance\": { \"grievanceId\": 1 }, " + // Changed from 3 to 1
        "\"user\": { \"userId\": 1 } " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/comments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("We have noted your complaint and will look into it"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(false))
            .andReturn();
}

@Test
@Order(73)
public void Day12_testGetAllComments() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/comments")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("We have noted your complaint and will look into it"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].isInternal").value(false))
            .andReturn();
}

@Test
@Order(74)
public void Day12_testGetCommentById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/comments/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("We have noted your complaint and will look into it"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(false))
            .andReturn();
}

@Test
@Order(75)
public void Day12_testUpdateComment() throws Exception {
    String requestBody = "{ " +
        "\"content\": \"Updated comment: We are investigating this issue\", " +
        "\"isInternal\": true " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/comments/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Updated comment: We are investigating this issue"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(true))
            .andReturn();
}



@Test
@Order(76)
    void Day13_test_execption_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }


	
@Test
@Order(77)
void Day13_test_GloabalEception_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
}


@Test
@Order(78)
    void Day14test_configuartion_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

@Test
@Order(79)
public void Day15_testAOPLogFileExists() {

    assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
   
}



}
