package com.quasar.sika.design.server;


import com.sika.code.GeneratorCodeDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daiqi
 * @create 2019-06-07 8:48
 */
@Slf4j
public class GenerateCodeConfig {

    /** 路径配置 */
    private static String projectPrefix = "quasar-sika-design-server";
    private static String basePackagePathPrefixForJava = "src/main/java/com/quasar/sika/design/server/business";
    private static String basePackagePathPrefixForXml = "src/main/resources/mapper";
    private static String modulePackage = "com.quasar.sika.design.server";

    /** 数据库配置 */
    private static String tablePrefix = "sika_";
    private static String dataBaseUrl = "121.89.202.68";
    private static String dataBaseName = "sika-design-admin";
    private static String dataBasePort = "3306";
    private static String username = "root";
    private static String password = "SikaDesignAdmin20201225";

    public static GeneratorCodeDTO buildGeneratorCodeDTO(String tableName, String author) {
        GeneratorCodeDTO generatorCodeDTO = new GeneratorCodeDTO();

        /** 父包 */
        generatorCodeDTO.setParentPackage(modulePackage + ".business")
                .setModulePackage(modulePackage)
                /** common的path */
                .setPathForDataaccess(buildFullPathForJava("dataaccess"))
                /** common类的path */
                .setPathForCommon(buildFullPathForJava("common"))
                /** service类path */
                .setPathForCore(buildFullPathForJava("core"))
                /** web的path */
                .setPathForWeb(buildFullPathForJava("web"))
                /** api的path */
                .setPathForApi(buildFullPathForJava("api"))
                /** xml的path */
                .setPathForXml(buildFullPathForXml("dataaccess"))

                .setDataBaseUrl(dataBaseUrl)
                .setDataBaseName(dataBaseName)
                .setDataBasePort(dataBasePort)
                .setUsername(username)
                .setPassword(password)

                /** 表名 */
                .setTableName(tableName)
                /** 表前缀 */
                .setSubPrefix(tablePrefix)
                /** 作者 */
                .setAuthor(author);

        return generatorCodeDTO;
    }

    private static String buildFullPathForJava(String projectSuffix) {
        StringBuilder stringBuilder = buildFullPathCore(projectSuffix, basePackagePathPrefixForJava);
        log.info(projectSuffix + "的全路径为：" + stringBuilder);
        return stringBuilder.toString();
    }

    private static String buildFullPathForXml(String projectSuffix) {
        StringBuilder stringBuilder = buildFullPathCore(projectSuffix, basePackagePathPrefixForXml);
        log.info(projectSuffix + "的全路径为：" + stringBuilder);
        return stringBuilder.toString();
    }

    protected static StringBuilder buildFullPathCore(String projectSuffix, String basePackagePathPrefix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/")
                .append(projectPrefix)
                .append("-")
                .append(projectSuffix)
                .append("/")
                .append(basePackagePathPrefix);
        return stringBuilder;
    }
}
