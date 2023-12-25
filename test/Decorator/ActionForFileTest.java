//package Decorator;
//
//import org.junit.jupiter.api.TestInstance;
//
//import Enum.Actions;
//import Enum.Types;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import java.io.File;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class ActionForFileTest {
//
//    private ActionForFile createActionForFile;
//    private File file;
//
//    @Test
//    void createAction() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ARCHIVING, Types.ZIP);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction2() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ARCHIVING, Types.JAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction3() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ARCHIVING, Types.RAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction4() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT, Types.ZIP);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction5() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT, Types.JAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction6() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT, Types.RAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_test2.xml");
//        Assertions.assertTrue(file1.exists());
//    }
//
//
//    @Test
//    void createAction7() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.ZIP);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/archived_encrypted_test2.zip");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction8() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.JAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/archived_encrypted_test2.jar");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction9() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.RAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/archived_encrypted_test2.rar");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction10() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.ZIP);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_archived_test2.zip");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction11() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.JAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/encrypted_archived_test2.jar");
//        Assertions.assertTrue(file1.exists());
//    }
//
//    @Test
//    void createAction12() throws Exception {
//        file = new File("src/res/test2.xml");
//        createActionForFile = new ActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVING, Types.RAR);
//        createActionForFile.CreateAction();
//        createActionForFile.start();
//        File file1 = new File("src/res/archived_encrypted_test2.rar");
//        Assertions.assertTrue(file1.exists());
//    }
//
//}