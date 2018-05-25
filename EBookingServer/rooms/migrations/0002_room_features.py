# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-27 14:23
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('rooms', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='room',
            name='features',
            field=models.CharField(choices=[('T', 'Television'), ('W', 'Whiteboard'), ('P', 'Projector'), ('C', 'Camera'), ('M', 'Monitors'), ('CM', 'Computer Monitors')], default=1, max_length=3),
            preserve_default=False,
        ),
    ]
