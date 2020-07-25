//tag::basicauth[]
grails.plugin.springsecurity.useBasicAuth = true
//end::basicauth[]

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'example.grails.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'example.grails..UserRole'
grails.plugin.springsecurity.authority.className = 'example.grails..Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
/*
	[pattern:  '/users',         filters:  'nonAuthFilter'],
*/
	[pattern:  '/h2-console/**',         filters:  'nonAuthFilter'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
grails.plugin.springsecurity.controllerAnnotations.interceptUrlMap  = [
		[pattern: '/users',   access: ['ROLE_ADMIN', 'ROLE_USER']]
]
