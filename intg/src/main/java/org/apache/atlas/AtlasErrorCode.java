/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.text.MessageFormat;
import java.util.Arrays;

public enum AtlasErrorCode {
    NO_SEARCH_RESULTS(204, "ATLAS-204-00-001", "Given search filter {0} did not yield any results"),

    UNKNOWN_TYPE(400, "ATLAS-400-00-001", "Unknown type {0} for {1}.{2}"),
    CIRCULAR_REFERENCE(400, "ATLAS-400-00-002", "{0}: invalid supertypes - circular reference back to self {1}"),
    INCOMPATIBLE_SUPERTYPE(400, "ATLAS-400-00-003", "{0}: incompatible supertype {1}"),
    UNKNOWN_CONSTRAINT(400, "ATLAS-400-00-004", "{0}.{1}: unknown constraint {1}"),
    UNSUPPORTED_CONSTRAINT(400, "ATLAS-400-00-005", "{0}.{1} : {2} constraint not supported"),
    CONSTRAINT_NOT_SATISFIED(400, "ATLAS-400-00-006", "{0}.{1} : {2} incompatible attribute type {3}"),
    CONSTRAINT_MISSING_PARAMS(400, "ATLAS-400-00-007", "{0}.{1} : invalid constraint. missing parameter {2} in {3}. params={4}"),
    CONSTRAINT_NOT_EXIST(400, "ATLAS-400-00-008", "{0}.{1} : invalid constraint. {2} {3}.{4} does not exist"),
    CONSTRAINT_NOT_MATCHED(400, "ATLAS-400-00-009", "{0}.{1} : invalid constraint. Data type of {2} {3}.{4} should be {5}, but found {6}"),
    UNKNOWN_TYPENAME(400, "ATLAS-400-00-00A", "{0}: Unknown/invalid typename"),
    CONSTRAINT_NOT_SUPPORTED_ON_MAP_TYPE(400, "ATLAS-400-00-00B", "{0}.{1} : constraints not supported on map type {2}"),
    CANNOT_ADD_MANDATORY_ATTRIBUTE(400, "ATLAS-400-00-00C", "{0}.{1} : can not add mandatory attribute"),
    ATTRIBUTE_DELETION_NOT_SUPPORTED(400, "ATLAS-400-00-00D", "{0}.{1} : attribute delete not supported"),
    SUPERTYPE_REMOVAL_NOT_SUPPORTED(400, "ATLAS-400-00-00E", "superType remove not supported"),
    UNEXPECTED_TYPE(400, "ATLAS-400-00-00F", "expected type {0}; found {1}"),
    TYPE_MATCH_FAILED(400, "ATLAS-400-00-010", "Given type {0} doesn't match {1}"),
    INVALID_TYPE_DEFINITION(400, "ATLAS-400-00-011", "Invalid type definition {0}"),
    INVALID_ATTRIBUTE_TYPE_FOR_CARDINALITY(400, "ATLAS-400-00-012", "Cardinality of attribute {0}.{1} requires a list or set type"),
    ATTRIBUTE_UNIQUE_INVALID(400, "ATLAS-400-00-013", "Type {0} with unique attribute {1} does not exist"),
    TYPE_NAME_INVALID(400, "ATLAS-400-00-014", "Type {0} with name {1} does not exist"),
    TYPE_CATEGORY_INVALID(400, "ATLAS-400-00-015", "Type Category {0} is invalid"),
    PATCH_NOT_APPLICABLE_FOR_TYPE(400, "ATLAS-400-00-016", "{0} - invalid patch for type {1}"),
    PATCH_FOR_UNKNOWN_TYPE(400, "ATLAS-400-00-017", "{0} - patch references unknown type {1}"),
    PATCH_INVALID_DATA(400, "ATLAS-400-00-018", "{0} - patch data is invalid for type {1}"),
    TYPE_NAME_INVALID_FORMAT(400, "ATLAS-400-00-019", "{0}: invalid name for {1}.  Names must consist of a letter followed by a sequence of letter, number, or '_' characters"),
    ATTRIBUTE_NAME_INVALID(400, "ATLAS-400-00-020", "{0}: invalid name. Attribute name must not contain query keywords"),
    INVALID_PARAMETERS(400, "ATLAS-400-00-01A", "invalid parameters: {0}"),
    CLASSIFICATION_ALREADY_ASSOCIATED(400, "ATLAS-400-00-01B", "instance {0} already is associated with classification {1}"),
    CONSTRAINT_INVERSE_REF_ATTRIBUTE_INVALID_TYPE(400, "ATLAS-400-00-01C", "{0}.{1}: invalid {2} constraint. Attribute {3} is not an entity type"),
    CONSTRAINT_INVERSE_REF_INVERSE_ATTRIBUTE_NON_EXISTING(400, "ATLAS-400-00-01D", "{0}.{1}: invalid {2} constraint. Inverse attribute {3}.{4} does not exist"),
    CONSTRAINT_INVERSE_REF_INVERSE_ATTRIBUTE_INVALID_TYPE(400, "ATLAS-400-00-01E", "{0}.{1}: invalid {2} constraint. Inverse attribute {3}.{4} is not an entity type"),
    CONSTRAINT_OWNED_REF_ATTRIBUTE_INVALID_TYPE(400, "ATLAS-400-00-01F", "{0}.{1}: invalid {2} constraint. Attribute {3} is not an entity type"),
    CANNOT_MAP_ATTRIBUTE(400, "ATLAS-400-00-020", "cannot map attribute: {0} of type: {1} from vertex"),
    INVALID_OBJECT_ID(400, "ATLAS-400-00-021", "ObjectId is not valid {0}"),
    UNRESOLVED_REFERENCES_FOUND(400, "ATLAS-400-00-022", "Unresolved references: byId={0}; byUniqueAttributes={1}"),
    UNKNOWN_ATTRIBUTE(400, "ATLAS-400-00-023", "Attribute {0} not found for type {1}"),
    SYSTEM_TYPE(400, "ATLAS-400-00-024", "{0} is a System-type"),
    INVALID_STRUCT_VALUE(400, "ATLAS-400-00-025", "not a valid struct value {0}"),
    INSTANCE_LINEAGE_INVALID_PARAMS(400, "ATLAS-400-00-026", "Invalid lineage query parameters passed {0}: {1}"),
    ATTRIBUTE_UPDATE_NOT_SUPPORTED(400, "ATLAS-400-00-027", "{0}.{1} : attribute update not supported"),
    INVALID_VALUE(400, "ATLAS-400-00-028", "invalid value: {0}"),
    BAD_REQUEST(400, "ATLAS-400-00-029", "{0}"),
    PARAMETER_PARSING_FAILED(400, "ATLAS-400-00-02A", "Parameter parsing failed at: {0}"),
    MISSING_MANDATORY_ATTRIBUTE(400, "ATLAS-400-00-02B", "Mandatory field {0}.{1} has empty/null value"),
    RELATIONSHIPDEF_INSUFFICIENT_ENDS(400,  "ATLAS-400-00-02C", "relationshipDef {0} creation attempted without 2 ends"),
    RELATIONSHIPDEF_DOUBLE_CONTAINERS(400,  "ATLAS-400-00-02D", "relationshipDef {0} creation attempted with both ends as containers"),
    RELATIONSHIPDEF_UNSUPPORTED_ATTRIBUTE_TYPE(400,  "ATLAS-400-00-02F", "Cannot set an Attribute with type {0} on relationship def {1}, as it is not a primitive type "),
    RELATIONSHIPDEF_ASSOCIATION_AND_CONTAINER(400,  "ATLAS-400-00-030", "ASSOCIATION relationshipDef {0} creation attempted with an end specifying isContainer"),
    RELATIONSHIPDEF_COMPOSITION_NO_CONTAINER(400,  "ATLAS-400-00-031", "COMPOSITION relationshipDef {0} creation attempted without an end specifying isContainer"),
    RELATIONSHIPDEF_AGGREGATION_NO_CONTAINER(400,  "ATLAS-400-00-032", "AGGREGATION relationshipDef {0} creation attempted without an end specifying isContainer"),
    RELATIONSHIPDEF_COMPOSITION_MULTIPLE_PARENTS(400,  "ATLAS-400-00-033", "COMPOSITION relationshipDef {0} can only have one parent; so cannot have SET cardinality on children"),
    RELATIONSHIPDEF_LIST_ON_END(400,  "ATLAS-400-00-034", "relationshipDef {0} cannot have a LIST cardinality on an end"),
    RELATIONSHIPDEF_INVALID_END_TYPE(400,  "ATLAS-400-00-035", "relationshipDef {0} has invalid end type {1}"),
    INVALID_RELATIONSHIP_END_TYPE(400, "ATLAS-400-00-036", "invalid relationshipDef: {0}: end type 1: {1}, end type 2: {2}"),
    RELATIONSHIPDEF_INVALID_END1_UPDATE(400, "ATLAS-400-00-037", "invalid update for relationshipDef {0}: new end1 {1}, existing end1 {2}"),
    RELATIONSHIPDEF_INVALID_END2_UPDATE(400, "ATLAS-400-00-038", "invalid update for relationshipDef {0}: new end2 {1}, existing end2 {2}"),
    RELATIONSHIPDEF_INVALID_CATEGORY_UPDATE(400, "ATLAS-400-00-039", "invalid  update for relationship {0}: new relationshipDef category {1}, existing relationshipDef category {2}"),
    RELATIONSHIPDEF_INVALID_NAME_UPDATE(400, "ATLAS-400-00-040", "invalid relationshipDef rename for relationship guid {0}: new name {1}, existing name {2}"),
    RELATIONSHIPDEF_END1_NAME_INVALID(400, "ATLAS-400-00-041", "{0}: invalid end1 name. Name must not contain query keywords"),
    RELATIONSHIPDEF_END2_NAME_INVALID(400, "ATLAS-400-00-042", "{0}: invalid end2 name. Name must not contain query keywords"),
    RELATIONSHIPDEF_NOT_DEFINED(400, "ATLAS-400-00-043", "No relationshipDef defined between {0} and {1} on attribute: {2}"),
    RELATIONSHIPDEF_INVALID(400, "ATLAS-400-00-044", "Invalid relationshipDef: {0}"),
    RELATIONSHIP_INVALID_ENDTYPE(400, "ATLAS-400-00-045", "Invalid entity-type for relationship attribute ‘{0}’: entity specified (guid={1}) is of type ‘{2}’, but expected type is ‘{3}’"),
    UNKNOWN_CLASSIFICATION(400, "ATLAS-400-00-046", "{0}: Unknown/invalid classification"),
    INVALID_SEARCH_PARAMS(400, "ATLAS-400-00-047", "No search parameter was found. One of the following MUST be specified in the request; typeName, classification or queryText"),
    INVALID_RELATIONSHIP_ATTRIBUTE(400, "ATLAS-400-00-048", "Expected attribute {0} to be a relationship but found type {1}"),
    INVALID_RELATIONSHIP_TYPE(400, "ATLAS-400-00-049", "Invalid entity type '{0}', guid '{1}' in relationship search"),
    INVALID_IMPORT_ATTRIBUTE_TYPE_CHANGED(400, "ATLAS-400-00-050", "Attribute {0}.{1} is of type {2}. Import has this attribute type as {3}"),
    ENTITYTYPE_REMOVAL_NOT_SUPPORTED(400, "ATLAS-400-00-051", "EntityTypes cannot be removed from ClassificationDef ‘{0}‘"),
    CLASSIFICATIONDEF_INVALID_ENTITYTYPES(400, "ATLAS-400-00-052", "ClassificationDef ‘{0}‘ has invalid ‘{1}‘ in entityTypes"),
    CLASSIFICATIONDEF_PARENTS_ENTITYTYPES_DISJOINT(400, "ATLAS-400-00-053", "ClassificationDef ‘{0}‘ has supertypes whose entityTypes are disjoint; e.g. 2 supertypes that are not related by inheritance specify different non empty entityType lists. This means the child cannot honour the restrictions specified in both parents."),
    CLASSIFICATIONDEF_ENTITYTYPES_NOT_PARENTS_SUBSET(400, "ATLAS-400-00-054", "ClassificationDef ‘{0}‘ has entityTypes ‘{1}‘ which are not subsets of it's supertypes entityTypes"),
    INVALID_ENTITY_FOR_CLASSIFICATION (400, "ATLAS-400-00-055", "Entity (guid=‘{0}‘,typename=‘{1}‘) cannot be classified by Classification ‘{2}‘, because ‘{1}‘ is not in the ClassificationDef's restrictions."),
    SAVED_SEARCH_CHANGE_USER(400, "ATLAS-400-00-056", "saved-search {0} can not be moved from user {1} to {2}"),
    INVALID_QUERY_PARAM_LENGTH(400, "ATLAS-400-00-057" , "Length of query param {0} exceeds the limit"),

    // All Not found enums go here
    TYPE_NAME_NOT_FOUND(404, "ATLAS-404-00-001", "Given typename {0} was invalid"),
    TYPE_GUID_NOT_FOUND(404, "ATLAS-404-00-002", "Given type guid {0} was invalid"),
    EMPTY_RESULTS(404, "ATLAS-404-00-004", "No result found for {0}"),
    INSTANCE_GUID_NOT_FOUND(404, "ATLAS-404-00-005", "Given instance guid {0} is invalid/not found"),
    INSTANCE_LINEAGE_QUERY_FAILED(404, "ATLAS-404-00-006", "Instance lineage query failed {0}"),
    INSTANCE_CRUD_INVALID_PARAMS(404, "ATLAS-404-00-007", "Invalid instance creation/updation parameters passed : {0}"),
    CLASSIFICATION_NOT_FOUND(404, "ATLAS-404-00-008", "Given classification {0} was invalid"),
    INSTANCE_BY_UNIQUE_ATTRIBUTE_NOT_FOUND(404, "ATLAS-404-00-009", "Instance {0} with unique attribute {1} does not exist"),
    REFERENCED_ENTITY_NOT_FOUND(404, "ATLAS-404-00-00A", "Referenced entity {0} is not found"),
    INSTANCE_NOT_FOUND(404, "ATLAS-404-00-00B", "Given instance is invalid/not found: {0}"),
    RELATIONSHIP_GUID_NOT_FOUND(404, "ATLAS-404-00-00C", "Given relationship guid {0} is invalid/not found"),
    RELATIONSHIP_CRUD_INVALID_PARAMS(404, "ATLAS-404-00-00D", "Invalid relationship creation/updation parameters passed : {0}"),
    RELATIONSHIPDEF_END_TYPE_NAME_NOT_FOUND(404, "ATLAS-404-00-00E", "RelationshipDef {0} endDef typename {0} cannot be found"),

    // All data conflict errors go here
    TYPE_ALREADY_EXISTS(409, "ATLAS-409-00-001", "Given type {0} already exists"),
    TYPE_HAS_REFERENCES(409, "ATLAS-409-00-002", "Given type {0} has references"),
    INSTANCE_ALREADY_EXISTS(409, "ATLAS-409-00-003", "failed to update entity: {0}"),
    RELATIONSHIP_ALREADY_EXISTS(409, "ATLAS-409-00-004", "relationship {0} already exists between entities {1} and {2}"),
    TYPE_HAS_RELATIONSHIPS(409, "ATLAS-409-00-005", "Given type {0} has associated relationshipDefs"),
    SAVED_SEARCH_ALREADY_EXISTS(409, "ATLAS-409-00-006", "search named {0} already exists for user {1}"),

    // All internal errors go here
    INTERNAL_ERROR(500, "ATLAS-500-00-001", "Internal server error {0}"),
    INDEX_CREATION_FAILED(500, "ATLAS-500-00-002", "Index creation failed for {0}"),
    INDEX_ROLLBACK_FAILED(500, "ATLAS-500-00-003", "Index rollback failed for {0}"),
    DISCOVERY_QUERY_FAILED(500, "ATLAS-500-00-004", "Discovery query failed {0}"),
    FAILED_TO_OBTAIN_TYPE_UPDATE_LOCK(500, "ATLAS-500-00-005", "Failed to get the lock; another type update might be in progress. Please try again"),
    FAILED_TO_OBTAIN_IMPORT_EXPORT_LOCK(500, "ATLAS-500-00-006", "Another import or export is in progress. Please try again"),
    NOTIFICATION_FAILED(500, "ATLAS-500-00-007", "Failed to notify {0} for change {1}"),
    FAILED_TO_OBTAIN_GREMLIN_SCRIPT_ENGINE(500, "ATLAS-500-00-008", "Failed to obtain gremlin script engine: {0}"),
    JSON_ERROR_OBJECT_MAPPER_NULL_RETURNED(500, "ATLAS-500-00-009", "ObjectMapper.readValue returned NULL for class: {0}"),
    GREMLIN_SCRIPT_EXECUTION_FAILED(500, "ATLAS-500-00-00A", "Gremlin script execution failed: {0}"),

    CURATOR_FRAMEWORK_UPDATE(500, "ATLAS-500-00-00B", "ActiveInstanceState.update resulted in exception."),
    QUICK_START(500, "ATLAS-500-00-00C", "Failed to run QuickStart: {0}"),
    EMBEDDED_SERVER_START(500, "ATLAS-500-00-00D", "EmbeddedServer.Start: failed!"),
    STORM_TOPOLOGY_UTIL(500, "ATLAS-500-00-00E", "StormToplogyUtil: {0}"),
    SQOOP_HOOK(500, "ATLAS-500-00-00F", "SqoopHook: {0}"),
    HIVE_HOOK(500, "ATLAS-500-00-010", "HiveHook: {0}"),
    HIVE_HOOK_METASTORE_BRIDGE(500, "ATLAS-500-00-011", "HiveHookMetaStoreBridge: {0}"),

    DATA_ACCESS_SAVE_FAILED(500, "ATLAS-500-00-00B", "Save failed: {0}"),
    DATA_ACCESS_LOAD_FAILED(500, "ATLAS-500-00-00C", "Load failed: {0}");

    private String errorCode;
    private String errorMessage;
    private Response.Status httpCode;

    private static final Logger LOG = LoggerFactory.getLogger(AtlasErrorCode.class);

    AtlasErrorCode(int httpCode, String errorCode, String errorMessage) {
        this.httpCode = Response.Status.fromStatusCode(httpCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;

    }

    public String getFormattedErrorMessage(String... params) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(String.format("<== AtlasErrorCode.getMessage(%s)", Arrays.toString(params)));
        }

        MessageFormat mf = new MessageFormat(errorMessage);
        String result = mf.format(params);

        if (LOG.isDebugEnabled()) {
            LOG.debug(String.format("==> AtlasErrorCode.getMessage(%s): %s", Arrays.toString(params), result));
        }
        return result;
    }

    public Response.Status getHttpCode() {
        return httpCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
