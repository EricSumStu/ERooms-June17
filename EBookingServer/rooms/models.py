from django.db import models

ZONES = (
        ('1', 'Zone 1'),
        ('3', 'Zone 3'),
        ('4', 'Zone 4'),
        ('5', 'Zone 5'),
        ('6', 'Zone 6'),
        ('7', 'Zone 7'),
        ('8', 'Zone 8'),
        ('9', 'Zone 9')
)
#FEATURES1 = (
           #('T', 'Television'),
           #('W', 'Whiteboard'),
           #('P', 'Projector'),
           #('C', 'Camera'),
           #('M','Monitors'),
           #('CM', 'Computer Monitors')
#)
#FEATURES2 = (
           #('T', 'Television'),
           #('W', 'Whiteboard'),
           #('P', 'Projector'),
           #('C', 'Camera'),
           #('M','Monitors'),
           #('CM', 'Computer Monitors')
#)
#FEATURES3 = (
          # ('T', 'Television'),
           #('W', 'Whiteboard'),
           #('P', 'Projector'),
           #('C', 'Camera'),
           #('M','Monitors'),
          # ('CM', 'Computer Monitors'),
           
           
#)

# Create your models here.
class Room(models.Model):
    name = models.CharField(max_length=200)
    zone = models.CharField(max_length=1, choices=ZONES)
    capacity = models.IntegerField()
    features1 = models.CharField(max_length=200, blank=True)#, choices=FEATURES1)
    features2 = models.CharField(max_length=200, blank=True)#, choices=FEATURES2)
    features3 = models.CharField(max_length=200, blank=True)#, choices=FEATURES3)
    available = models.BooleanField(default=False)

    def __str__(self):
        return self.name
    
# TODO: Add Features
    # See: https://docs.djangoproject.com/en/1.11/topics/db/models/


