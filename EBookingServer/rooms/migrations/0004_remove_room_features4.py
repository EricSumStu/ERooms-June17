# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-28 09:36
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('rooms', '0003_auto_20170628_1027'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='room',
            name='features4',
        ),
    ]
