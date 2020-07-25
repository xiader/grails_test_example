import example.grails.CustomObjectMarshallers
import example.grails.MarshallerInitializer
import example.grails.NonAuthenticationFilter
import example.grails.TableMarshaller
import example.grails.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    nonAuthFilter(NonAuthenticationFilter)
    customObjectMarshallers(CustomObjectMarshallers) {
        marshallers = [
                new TableMarshaller()
        ]
    }

    marshallerInitializer(MarshallerInitializer) {
        customObjectMarshallers = ref('customObjectMarshallers')
    }
}
