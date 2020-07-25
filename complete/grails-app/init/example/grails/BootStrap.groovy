package example.grails

import grails.util.Environment
import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {
    public static final String ROLE__USER = 'ROLE_USER'
    public static final String ROLE__ADMIN = 'ROLE_ADMIN'
    UserService userService

    RoleService roleService

    UserRoleService userRoleService

//    TableService tableService

    def init = { servletContext ->

  /*      if (Environment.current == Environment.DEVELOPMENT) {
            final String username = 'admin'
            final String password = 'admin'
            User user = userService.save(username, password, true, false, false, false)
        }*/
        new User2(username: "shvts", lastname: "igorovich", email: "ego@hmail.com", firstname: "yuri").save()
        new User2(username: "2222", lastname: "2222", email: "222@hmail.com", firstname: "222").save()

        new Table(name: "table - James Bond", participants: 7).save()
        new Table(name: "table - Mission Impossible", participants: 4).save()

        List<String> authorities = [ROLE__ADMIN, ROLE__USER]
        authorities.each { String authority ->
            if ( !roleService.findByAuthority(authority) ) {
                roleService.save(authority)
            }
        }

        if ( !userService.findByUsername('admin') ) {
            User u = userService.save('admin', 'admin')
            userRoleService.save(u, roleService.findByAuthority(ROLE__ADMIN))
        }

        if ( !userService.findByUsername('user') ) {
            User u = userService.save('user', 'user')
            userRoleService.save(u, roleService.findByAuthority(ROLE__USER))
        }

    }
    def destroy = {
    }
}
