package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.INotificationController
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.service.INotificationService
import org.springframework.web.bind.annotation.*

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/

@RestController
class NotificationController(
    private val service: INotificationService): INotificationController {

    @PostMapping(value = ["/api/notifications"], produces = ["application/json"], consumes = ["application/json"])
    override fun createNotification(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/notifications/{notificationId}"], produces = ["application/json"])
    override fun readNotification(
        @PathVariable("notificationId") notificationId: String): WebResponse<Response> {
        val response = service.read(notificationId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/notifications/{notificationId}"], produces = ["application/json"])
    override fun deleteNotification(
        @PathVariable("notificationId") notificationId: String): WebResponse<String> {
        service.delete(notificationId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = notificationId
        )
    }

    @GetMapping(value = ["/api/notifications"], produces = ["application/json"])
    override fun listNotification(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response>> {
        val response = service.list(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/notifications/owner/{recipientId}"], produces = ["application/json"])
    override fun listNotification(
        @PathVariable("recipientId") recipientId: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response>> {
        val response = service.list(recipientId, ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}