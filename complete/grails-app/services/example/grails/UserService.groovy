package example.grails

import grails.gorm.services.Service

@Service(User)
interface UserService {

    User save(String username, String password)

    User save (String username, String password, boolean enabled, boolean accountExpired, boolean accountLocked, boolean passwordExpired)

    User findByUsername(String username)

    void delete(Serializable id)

    int count()

   // User findAllByUser(User user)
}