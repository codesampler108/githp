package in.awsexplorer.teamchat.dbsetup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class DbSetupUtil {

	public static void executeSqlFiles(File[] ddlFiles, Connection conn) {
		try {
			for (File file : ddlFiles) {
				String fileContent;

				fileContent = FileUtils.readFileToString(file, "UTF-8");

				String[] statementArray = fileContent.split(";");
				String[] ddlStatement = Arrays.copyOf(statementArray, statementArray.length - 1);
				runSqlStatements(ddlStatement, conn);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void executeSqlFiles(List<String> ddlFiles, Connection conn) {
		for (String fileLocation : ddlFiles) {
			String[] ddlStatement;
			try {
				ddlStatement = readDdlFromFileLocation(fileLocation);
				runSqlStatements(ddlStatement, conn);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void executeSqlFiles(String[] ddlStatement, Connection conn) {
		try {
			runSqlStatements(ddlStatement, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String[] readDdlFromFileLocation(String fileLocation) throws IOException {
		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileLocation);
		if (null == inputStream) {
			throw new FileNotFoundException("Could not read the ddl file:" + fileLocation);
		}
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		String[] statementArray = resultStringBuilder.toString().split(";");
		String[] ddlStatements = Arrays.copyOf(statementArray, statementArray.length - 1);
		return ddlStatements;
	}

	private static void runSqlStatements(String[] statements, Connection conn) throws SQLException {
		Arrays.asList(statements).forEach(statement -> {
			System.out.println("Running:" + statement);
			try {
				PreparedStatement pstmt = conn.prepareStatement(statement);
				pstmt.execute();
				pstmt.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		});

	}

}
