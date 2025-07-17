package com.fire.adforge.logic

import com.fire.adforge.model.MailTemplate
import com.fire.adforge.model.MailTemplates

object MailCenterLogic {

    fun getTemplateById(id: String): MailTemplate? {
        return MailTemplates.systemTemplates.find { it.id == id }
    }

    fun listAllTemplates(): List<MailTemplate> {
        return MailTemplates.systemTemplates
    }
}
