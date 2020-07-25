package example.grails


class MarshallerInitializer {

    CustomObjectMarshallers customObjectMarshallers

    void initialize() {
        customObjectMarshallers.register()
    }
}