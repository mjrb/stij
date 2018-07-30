import {Stitch} from 'mongodb-stitch-browser-sdk'
window.Stitch=Stitch

import{
    AnonymousCredential,
    CustomCredential,
    FacebookCredential,
    GoogleCredential,
    ServerApiKeyCredential,
    UserApiKeyCredential,
    UserPasswordCredential
} from 'mongodb-stitch-browser-sdk'
//TODO what package is this in?
import {StitchAuthResponseCredential} from 'mongodb-stitch-core-sdk'

window.StitchCredentials={
    anonymous:AnonymousCredential,
    custom:CustomCredential,
    facebook:FacebookCredential,
    google:GoogleCredential,
    serverApiKey:ServerApiKeyCredential,
    stitchAuthResponse:StitchAuthResponseCredential,
    userApiKey:UserApiKeyCredential,
    userPassword:UserPasswordCredential
}

//unfortunately by doing this i can't offer much customizablility
//to decrease the payload by not having all the packages
//I could split this into multiple extra libs, but thats too much to maintain
//atm because this is a side project
//my only advice would be to remove any packages you don't need by hand
//from here and in the source
//unless I get the closure npm module thing working. then we might get some
//dead code elimination
import {AwsS3ServiceClient}  from 'mongodb-stitch-browser-services-aws-s3'
import {AwsSesServiceClient} from 'mongodb-stitch-browser-services-aws-ses'
import {HttpServiceClient}   from 'mongodb-stitch-browser-services-http'
import {RemoteMongoClient}   from 'mongodb-stitch-browser-services-mongodb-remote'
import {TwilioServiceClient} from 'mongodb-stitch-browser-services-twilio'

window.StitchServiceClientFactories={
    awsS3:AwsS3ServiceClient.factory,
    awsSES:AwsSesServiceClient.factory,
    http:HttpServiceClient.factory,
    mongo:RemoteMongoClient.factory,
    twilio:TwilioServiceClient.factory
}

import {
    UserApiKeyAuthProviderClient,
    UserPasswordAuthProviderClient
} from 'mongodb-stitch-browser-sdk'

window.StitchAuthProviderClients={
    userApiKey:UserApiKeyAuthProviderClient,
    userPassword:UserPasswordAuthProviderClient
}
