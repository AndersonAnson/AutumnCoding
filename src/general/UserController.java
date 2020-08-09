//package general;
//
//import java.util.HashMap;
//
//public class UserController {
//    @Autowired
//    UserService userService;
//
//    HashMap<String, Object> hashMap = new HashMap<>();
//
//    public Object getUser(Long userId) {
//        UserVo result = userService.getUser(userId);
//        hashMap.put("Test", "Value");//多线程下应该用concurrentHashMap
//        return hashMap;
//    }
//}
