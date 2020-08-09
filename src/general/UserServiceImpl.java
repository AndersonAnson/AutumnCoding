//package general;
//
//public class UserServiceImpl implements UserService {
//    @Autowired
//    UserDao userDao;
//
//    UserVo userVo;
//
//    public UserVo getUser(Long userId) {
//        userVo = userDao.getUser(userId);//应该对共享资源进行线程不安全的处理
//        return userVo;
//    }
//}
