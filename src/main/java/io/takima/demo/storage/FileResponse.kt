package io.takima.demo.storage

class FileResponse(
        var name: String,
        var uri: String,
        var type: String,
        var size: Long) {

    constructor() : this("", "", "", 0)
}